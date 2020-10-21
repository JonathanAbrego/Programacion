#lang plai

(require "practica5-base.rkt")

(print-only-errors true)

(define (desugar expr)
  (type-case RCFAELS expr
    [idS (s) (id s)]
    [numS (n) (num n)]
    [boolS (b) (bool b)]
    [MListS (l) (MList (desugarMlist l))]
    [withS (l b) (app (fun (map (lambda (x) (bind-name x)) l)
                                     (desugar b))
                                (map (lambda (x) (desugar (bind-val x))) l))]
    [with*S (l b) (withsmulti l b)]
    [funS (params body) (fun params 
                             (desugar body))]
    [appS (f args) (app (desugar f) 
                        (map(lambda (arg) (desugar arg)) args))]
    [binopS (f l r) (binop f (desugar l) (desugar r))]
    [recS (name named-expr body) (rec name                
                                   (desugar named-expr)
                                   (desugar body))]
    [ifS (t v f) (ifR (desugar t)
                      (desugar v)
                      (desugar f))]
    [equal?S (prim seg) (equal?R (desugar prim) (desugar seg))]
    [unopS (f arg) (unop f (desugar arg))]    
    ))

(define (desugarMlist l)
  (cond
    [(MEmptyS? l) (MEmpty)]
    [(MConsS? l) (MCons (desugar (MConsS-mcar l)) (desugarMlist (MConsS-mcdr l)))]
    [else "error"]))


(define (withsmulti bindings body)
  (cond
    [(if (empty? bindings)
         (desugar body)
         (app (fun (list (bind-name (car bindings)))
                    (withsmulti (cdr bindings) body)) 
               (list (desugar (bind-val (car bindings))))))]))


(test (desugar (parse '{+ 3 4})) (binop + (num 3) (num 4)))
(test (desugar (parse '{+ {- 3 4} 7})) (binop + (binop - (num 3) (num 4)) (num 7)))
(test (desugar (parse '{with {{x {+ 5 5}}} x})) (app (fun '(x) (id 'x)) (list (binop + (num 5) (num 5))) ))

(define (cparse sexp)
  (desugar (parse sexp)))

(define (opbin op l r env)
  (cond
    [(and (numV? l) (numV? r)) (let ((res (op (numV-n l)
                                              (numV-n r))))
                                     (if (boolean? res)
                                         (boolV res)
                                         (numV res)))]
    [(and (boolV? l) (boolV? r)) (boolV (op (boolV-b l)
                                               (boolV-b r)))]))

(define (lookup name env)
  (cond
    [(mtSub? env) (error 'lookup "x symbol is not in the env")]
    [(aSub? env) (if (symbol=? (aSub-name env) name) 
                     (aSub-value env)
                     (lookup name (aSub-env env)))]))

(define (creaEnv params args env closureEnv)
  (if (empty? args)
      closureEnv
      (creaEnv (cdr params)
               (cdr args)
               env
               (aSub (car params)
                     (interp (car args) env)
                     closureEnv))))

(define (interp expr env)
  (type-case RCFAEL expr
    [num (n) (numV n)]
    [bool (b) (boolV b)]
    [id (name) (lookup name env)]
    [fun (params body) (closureV params body env)]
    [app (fun args) (local([define fun-val (interp fun env)])
                    (interp (closureV-body fun-val)
                            (creaEnv (closureV-param fun-val) 
                                     args 
                                     env 
                                     (closureV-env fun-val))))]
    [binop (f l r) (opbin f (interp l env) (interp r env) env)]
    [unop (op arg) (opun op (interp arg env))]
    [ifR (test truth falsity)
         (if (boolV-b (interp test env))
             (interp truth env)
             (interp falsity env))]
    [equal?R (fir sec) (eq (interp fir env) 
                           (interp sec env))]
    [rec (bound-id named-expr bound-body) (error 'interp "no implementado")] 
    [MList (l) (MListV (Mlistinterp l env))]))

(define (rinterp expr)
  (interp expr (mtSub)))

(define (Mlistinterp l env)
  (cond
    [(MEmpty? l) (MEmptyV)]
    [(MCons? l) (MConsV (interp (MCons-mcar l) env) 
                        (Mlistinterp (MCons-mcdr l) env))]))

(define (eq prim seg)
  (cond
    [(and (numV? prim) (numV? seg)) (boolV (equal? (numV-n prim) (numV-n seg)))]
    [(and (boolV? prim) (boolV? seg)) (boolV (equal? (boolV-b prim) (boolV-b seg)))]
    [(and (MListV? prim) (MListV? seg)) (boolV (eqMLista (MListV-l prim) (MListV-l seg)))]
    [else (error 'eq "No esta definido")]))

(define (eqMLista l1 l2)
  (cond
    [(or (MEmptyV? l1) (MEmptyV? l2)) (equal? l1 l2) ]
    [else (and (equal? (MConsV-mcar l1) (MConsV-mcar l2)) (eqMLista (MConsV-mcdr l1) (MConsV-mcdr l2)))]))

(define (opun f arg)
  (cond
    [(numV? arg) (let ((resultado (f (numV-n arg))))
                   (if (boolean? resultado)
                       (boolV resultado)
                       (numV resultado)))]
    [(boolV? arg) (let ((resultado (f (boolV-b arg))))
                   (if (boolean? resultado)
                       (boolV resultado)
                       (numV resultado)))]))

(test (rinterp (cparse '3)) (numV 3))
(test (rinterp (cparse '{+ 3 4})) (numV 7))
(test (rinterp (cparse '{+ {- 3 4} 7})) (numV 6))
(test (rinterp (cparse '{with {{x {+ 5 5}}} {+ x x}})) (numV 20))
(test (rinterp (cparse '{with {{x 5}} {+ x x}})) (numV 10))
(test (rinterp (cparse '{with {{x {+ 5 5}}} {with {{y {- x 3}}} {+ y y}}})) (numV 14))
(test (rinterp (cparse '{with {{x 5} {y {- 5 3}}} {+ x y}})) (numV 7))
(test (rinterp (cparse '{with {{x 5}} {+ x {with {{x 3}} 10}}})) (numV 15))
(test (rinterp (cparse '{with {{x 5}} {+ x {with {{x 3}} x}}})) (numV 8))
(test (rinterp (cparse '{with {{x 5}} {+ x {with {{y 3}} x}}})) (numV 10))
(test (rinterp (cparse '{with {{x 5}} {with {{y x}} y}})) (numV 5))
(test (rinterp (cparse '{with {{x 5}} {with {{x x}} x}})) (numV 5))
(test (rinterp (cparse '{{fun {x} x} 3})) (numV 3))
(test (rinterp (cparse '{{{fun {x} x} {fun {x} {+ x 5}}} 3})) (numV 8))
(test (rinterp (cparse '{with {{x 3}} {fun {y} {+ x y}}})) (closureV '(y) (binop + (id 'x) (id 'y)) (aSub 'x (numV 3) (mtSub))))
(test (rinterp (cparse '{with {{x 10}} {{fun {y} {+ y x}} {+ 5 x}}})) (numV 25))
(test (rinterp (cparse '{with {{x 1} {y 2} {z 3}} {+ {+ x y} z}})) (numV 6))
(test (rinterp (cparse '{{fun {x y z} {+ {+ x y} z}} 1 2 3})) (numV 6))
(test (rinterp (cparse '{with* {{x 3} {y {+ 2 x}} {z {+ x y}}} z})) (numV 8))
(test (rinterp (cparse '{with* {{x 3} {y {+ 2 x}} {x 10} {z {+ x y}}} z})) (numV 15))
(test/exn (rinterp (cparse '{with {{x 10} {x 20}} x})) "El id x está repetido")
(test (rinterp (cparse '{with* {{x 10} {x 20}} x})) (numV 20))
(test/exn (rinterp (cparse '{{fun {x y} y} 3 {+ 2 x}})) "x symbol is not in the env")

(test (rinterp (cparse 'true)) (boolV true))
(test (rinterp (cparse 'false)) (boolV false))
(test (rinterp (cparse '{MList (MEmpty)})) (MListV (MEmptyV)))
(test (rinterp (cparse '{MList {MCons {+ 2 3} {MCons {+ 5 10} {MEmpty}}}})) (MListV (MConsV (numV 5) (MConsV (numV 15) (MEmptyV)))))
(test (rinterp (cparse '{MList {MCons {or true false} {MEmpty}}})) (MListV (MConsV (boolV #t) (MEmptyV))))
(test (rinterp (cparse '{MList {MCons {with* {{x 10} {x 20}} x} {MEmpty}}})) (MListV (MConsV (numV 20) (MEmptyV))))
(test (rinterp (cparse '{if {> 13 7} 
                            15 
                            8})) (numV 15))
(test (rinterp (cparse '{with {{n 13}} 
                              {if {and {> n 7} {< n 15}}
                                  42 
                                  false}})) (numV 42))
(test (rinterp (cparse '{equal? 5 5})) (boolV #t))
(test (rinterp (cparse '{neg false})) (boolV #t))
(test (rinterp (cparse '{inc 4})) (numV 5))
(test (rinterp (cparse '(bool? false))) (boolV #t))
(test (rinterp (cparse '(and true true))) (boolV true))