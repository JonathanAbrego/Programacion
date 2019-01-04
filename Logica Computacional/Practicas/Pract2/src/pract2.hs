{-
   Lógica computacional 2017-1
      Noé Salomón Hernández Sánchez
      Albert M. Orozco Camacho
      C. Moisés Vázquez Reyes
      Diego Murillo Albarrán
      José Roberto Piche Limeta   
-}

--El índice de una variable es un entero
type VarIndex = Integer


-- El nombre de una función o un predicado es una cadena.
-- Por convención utilizamos minúsculas para funciones y mayúsculas para predicados.
type Name = String


-- Tipo de dato para representar términos.
-- Un término es una variable o un símbolo de función aplicado a una lista de términos. 
data Term = X VarIndex | Fn Name [Term] deriving Eq


-- Las variables son términos.            
type TVar = Term

{- Hacemos que sean instancia de Show para pintarlos bonito -}
instance Show Term where
      show t = case t of
                     X n -> "X"++show n
                     Fn a [] -> a
                     Fn f (t:ts) -> f++"("++show t++ponComas ts++")" where
                                 ponComas [] = []
                                 ponComas (t:ts) = ","++show t++ponComas ts 


-- Tipo de dato para representar fórmulas.
data Form  = Top | Bot | Pr Name [Term] | Eq Term Term | Neg Form | Or Form Form | And Form Form
            | Impl Form Form | Syss Form Form | All TVar Form | Ex TVar Form deriving Eq


{- Hacemos que sean instancia de Show para pintarlas bonito -}            
instance Show Form where 
      show f = case f of
                  --Atómicas
                  Top -> "⊤"               
                  Bot -> "⊥"
                  Pr p (t:ts) -> p++"("++show t++ponComas ts++")" where 
                                 ponComas [] = []
                                 ponComas (t:ts) = ","++show t++ponComas ts
                  --Igualdad               
                  Eq t1 t2 -> show t1++" = "++show t2 
                  --Negación
                  Neg Top -> "¬⊤"
                  Neg Bot -> "¬⊥"
                  Neg q@(Pr p ts) -> "¬"++show q
                  Neg f1@(Neg f2) -> "¬"++show f1
                  Neg g -> "¬("++show g++")"   
                  --Conjunción
                  And Top Top -> "⊤ ∧ ⊤"
                  And Top Bot -> "⊤ ∧ ⊥"
                  And Bot Top -> "⊥ ∧ ⊤"
                  And Bot Bot -> "⊥ ∧ ⊥"
                  And p1@(Pr p ts) p2@(Pr q ss) -> show p1++" ∧ "++show p2   
                  And f1 p2@(Pr q ss) -> case f1 of
                                           Neg g -> show f1++" ∧ "++show p2
                                           _ -> "("++show f1++") ∧ "++show p2
                  And p1@(Pr p ts) f2 -> case f2 of
                                           Neg g -> show p1++" ∧ "++show f2 
                                           _ -> show p1++" ∧ ("++show f2++")"    
                  And n1@(Neg f1) n2@(Neg f2) -> show n1++" ∧ "++show n2
                  And f1 n2@(Neg f2) -> "("++show f1++") ∧ "++show n2
                  And n1@(Neg f1) f2 -> show n1++" ∧ ("++show f2++")"                                              
                  And f1 f2 -> "("++show f1++") ∧ ("++show f2++")"
                  --Disyunción
                  Or Top Top -> "⊤ ∨ ⊤"
                  Or Top Bot -> "⊤ ∨ ⊥"
                  Or Bot Top -> "⊥ ∨ ⊤"
                  Or Bot Bot -> "⊥ ∨ ⊥"
                  Or p1@(Pr p ts) p2@(Pr q ss) -> show p1++" ∨ "++show p2   
                  Or f1 p2@(Pr q ss) -> case f1 of
                                           Neg g -> show f1++" ∨ "++show p2
                                           _ -> "("++show f1++") ∨ "++show p2
                  Or p1@(Pr p ts) f2 -> case f2 of
                                           Neg g -> show p1++" ∨ "++show f2 
                                           _ -> show p1++" ∨ ("++show f2++")"    
                  Or n1@(Neg f1) n2@(Neg f2) -> show n1++" ∨ "++show n2
                  Or f1 n2@(Neg f2) -> "("++show f1++") ∨ "++show n2
                  Or n1@(Neg f1) f2 -> show n1++" ∨ ("++show f2++")"                                              
                  Or f1 f2 -> "("++show f1++") ∨ ("++show f2++")"
                  --Implicación
                  Impl Top Top -> "⊤ ⟶ ⊤"
                  Impl Top Bot -> "⊤ ⟶ ⊥"
                  Impl Bot Top -> "⊥ ⟶ ⊤"
                  Impl Bot Bot -> "⊥ ⟶ ⊥"
                  Impl p1@(Pr p ts) p2@(Pr q ss) -> show p1++" ⟶  "++show p2   
                  Impl f1 p2@(Pr q ss) -> case f1 of
                                           Neg g -> show f1++" ⟶  "++show p2
                                           _ -> "("++show f1++") ⟶  "++show p2
                  Impl p1@(Pr p ts) f2 -> case f2 of
                                           Neg g -> show p1++" ⟶  "++show f2 
                                           _ -> show p1++" ⟶  ("++show f2++")"    
                  Impl n1@(Neg f1) n2@(Neg f2) -> show n1++" ⟶  "++show n2
                  Impl f1 n2@(Neg f2) -> "("++show f1++") ⟶  "++show n2
                  Impl n1@(Neg f1) f2 -> show n1++" ⟶  ("++show f2++")"                                              
                  Impl f1 f2 -> "("++show f1++") ⟶  ("++show f2++")"
                  --Doble implicación
                  Syss Top Top -> "⊤ ⟷ ⊤"
                  Syss Top Bot -> "⊤ ⟷ ⊥"
                  Syss Bot Top -> "⊥ ⟷ ⊤"
                  Syss Bot Bot -> "⊥ ⟷ ⊥"
                  Syss p1@(Pr p ts) p2@(Pr q ss) -> show p1++" ⟷ "++show p2   
                  Syss f1 p2@(Pr q ss) -> case f1 of
                                           Neg g -> show f1++" ⟷ "++show p2
                                           _ -> "("++show f1++") ⟷ "++show p2
                  Syss p1@(Pr p ts) f2 -> case f2 of
                                           Neg g -> show p1++" ⟷ "++show f2 
                                           _ -> show p1++" ⟷ ("++show f2++")"    
                  Syss n1@(Neg f1) n2@(Neg f2) -> show n1++" ⟷ "++show n2
                  Syss f1 n2@(Neg f2) -> "("++show f1++") ⟷ "++show n2
                  Syss n1@(Neg f1) f2 -> show n1++" ⟷ ("++show f2++")"                                              
                  Syss f1 f2 -> "("++show f1++") ⟷ ("++show f2++")"     
                  --Para todo...
                  All x f -> "∀"++show x++".["++show f++"]"   
                  --Para todo...
                  Ex x f -> "∃"++show x++".["++show f++"]"   
            
-- Una sustitución es una lista de pares cuya primer entrada es una variable 
-- y la segunda entrada es el término por el cual sustituimos la variable.
type Sust = [(TVar,Term)]


            {-DESDE AQUÍ COMIENZA LA PRÁCTICA-}

{-AUXILIARES:-}
--Nos da las variables de un término
varsT::Term->[VarIndex]
varsT term = case term of
            X n -> [n] 
            Fn _ [] -> []
            Fn _ ts -> concat [ varsT t | t<-ts]  
 

--Nos devuelve las variables libres de una fórmula.
fv::Form->[VarIndex]
fv form = case form of
            Top -> []
            Bot -> []
            Pr _ ts -> concat [ varsT t | t<-ts]
            Eq t1 t2 -> varsT t1 ++ varsT t2
            Neg f -> fv f
            And f1 f2 -> fv f1 ++ fv f2
            Or f1 f2 -> fv f1 ++ fv f2
            Impl f1 f2 -> fv f1 ++ fv f2
            Syss f1 f2 -> fv f1 ++ fv f2
            All (X n) f -> filter (n/=) $ fv f
            Ex (X n) f -> filter (n/=) $ fv f
            
            
         
--Nos devuelve las variables ligadas de una fórmula.
bv::Form->[VarIndex]
bv form = case form of
            Top -> []
            Bot -> []
            Pr _ ts -> []
            Eq t1 t2 -> varsT t1 ++ varsT t2
            Neg f -> bv f
            And f1 f2 -> bv f1 ++ bv f2
            Or f1 f2 -> bv f1 ++ bv f2
            Impl f1 f2 -> bv f1 ++ bv f2
            Syss f1 f2 -> bv f1 ++ bv f2
            All (X n) f -> n:(bv f)
            Ex (X n) f -> n:(bv f)


--Aplica sustitución en términos
apsubsT::Term->Sust->Term
apsubsT term sust = case term of
                  X n -> case sust of 
                           [] -> X n
                           (X m,tm):s -> if n==m then tm 
                                                 else apsubsT term s  
                  Fn _ [] -> term 
                  Fn f ts -> Fn f [apsubsT t sust | t<-ts]                              


--Aplica sustitución en fórmulas 
apsubsF::Form->Sust->Form
apsubsF form sust = case form of 
                  Top -> Top
                  Bot -> Bot
                  Pr p ts -> Pr p [apsubsT t sust | t<-ts]    
                  Eq t1 t2-> Eq (apsubsT t1 sust) (apsubsT t2 sust)
                  Neg f -> Neg (apsubsF f sust)
                  And f1 f2 -> And (apsubsF f1 sust) (apsubsF f2 sust)
                  Or f1 f2 -> Or (apsubsF f1 sust) (apsubsF f2 sust)
                  Impl f1 f2 -> Impl (apsubsF f1 sust) (apsubsF f2 sust)
                  Syss f1 f2 -> Syss (apsubsF f1 sust) (apsubsF f2 sust)
                  All (X n) f -> if (elem n $ varsSust sust) then form 
                                                             else All (X n) $ apsubsF f sust  
                  Ex (X n) f -> if (elem n $ varsSust sust) then form 
                                                             else Ex (X n) $ apsubsF f sust           

                  
--Nos devuelve las variables de una sustitución
varsSust::Sust->[VarIndex]
varsSust sust = concat [ [sacaN $ fst t]++(varsT $ snd t) | t<-sust ] where
                                       sacaN (X n) = n

                 
                                    
{-Para rectificar una fórmula, renombra las variables ligadas de tal manera que 
las variables libres y ligadas sean ajenas y no haya cuantificadores de la misma 
variable con alcances ajenos-}
renVL::Form->[VarIndex]->Form
renVL form ns = case form of
    Top -> Top
    Bot -> Bot
    Pr _ _ -> form 
    Eq _ _ -> form
    Neg f -> Neg $ renVL f ns
    And f1 f2 -> let f1' = renVL f1 ns in And f1' (renVL f2 $ ns++bv f1')
    Or f1 f2 -> let f1' = renVL f1 ns in Or f1' (renVL f2 $ ns++bv f1')
    Impl f1 f2 -> let f1' = renVL f1 ns in Impl f1' (renVL f2 $ ns++bv f1')
    Syss f1 f2 -> let f1' = renVL f1 ns in Syss f1' (renVL f2 $ ns++bv f1')
    All (X n) f -> if elem n ns then All (X m) (renVL (apsubsF f [(X n, X m)]) (m:ns))
                                else All (X n) $ renVL f ns where m = (maximum (fv f ++ bv f ++ ns) + 1)
    Ex (X n) f -> if elem n ns then Ex (X m) (renVL (apsubsF f [(X n, X m)]) (m:ns))
                                else Ex (X n) $ renVL f ns where m = (maximum (fv f ++ bv f ++ ns) + 1)


--Rectifica una fórmula, se da por hecho que no hay cuantificadores bobos :P
recF::Form->Form
recF f = renVL f $ fv f                                                     


--Elimina implicaciones
elimImp::Form->Form
elimImp form = case form of
    Top -> Top
    Bot -> Bot
    Pr _ _ -> form
    Eq _ _ -> form
    Neg f -> Neg $ elimImp f
    And f1 f2 -> And (elimImp f1) (elimImp f2)
    Or f1 f2 -> Or (elimImp f1) (elimImp f2)
    Impl f1 f2 -> Or (Neg $ elimImp f1) (elimImp f2)
    Syss f1 f2 -> And (elimImp (Impl f1 f2)) (elimImp (Impl f2 f1))
    All x f -> All x (elimImp f)
    Ex x f -> Ex x (elimImp f)
                   
--Devuelve la forman normal negativa
fnn::Form->Form
fnn = fnn . elimImp where
    fnn form = case form of
        Top -> Top
        Bot -> Bot 
        Pr _ _ -> form
        Eq _ _ -> form
        Neg f -> case f of
            Top -> form 
            Bot -> form
            Pr _ _ -> form
            Eq _ _ -> form
            Neg g-> fnn g
            And f1 f2 -> Or (fnn $ Neg f1) (fnn $ Neg f2)
            Or f1 f2 -> And (fnn $ Neg f1) (fnn $ Neg f2)
            Impl f1 f2 -> fnn $ Neg (elimImp f)
            Syss f1 f2 -> fnn $ Neg (elimImp f)
            All x g -> Ex x $ fnn $ Neg g
            Ex x g -> All x $ fnn $ Neg g
        And f1 f2 -> And (fnn f1) (fnn f2)
        Or f1 f2 -> Or (fnn f1) (fnn f2)
        Impl f1 f2 -> fnn $ elimImp form
        Syss f1 f2 -> fnn $ elimImp form
        All x f -> All x $ fnn $ elimImp f
        Ex x f -> Ex x $ fnn $ elimImp f 

--Devuelve la forma normal prenex, se da por hecho que antes se aplicó fnn
fnp::Form->Form
fnp = fnp . fnn where 
    fnp form = case form of
           And (All x f1) f2 -> All x $ fnp $ And f1 f2
           And f1 (All x f2) -> All x $ fnp $ And f1 f2
           And (Ex x f1) f2 -> Ex x $ fnp $ And f1 f2
           And f1 (Ex x f2) -> Ex x $ fnp $ And f1 f2
           Or (All x f1) f2 -> All x $ fnp $ Or f1 f2
           Or f1 (All x f2) -> All x $ fnp $ Or f1 f2
           Or (Ex x f1) f2 -> Ex x $ fnp $ Or f1 f2
           Or f1 (Ex x f2) -> Ex x $ fnp $ Or f1 f2
           All x f -> All x $ fnp f
           Ex x f -> Ex x $ fnp f
           _ ->form
                  
                  
--Elimina los cuantificadores para la forma normal Skolem
elimCuant::Form->(Int,Int,[Term])->Form
elimCuant form (cn, fn, ts) = case form of
      All x f -> elimCuant f (cn, fn, ts++[x])
      Ex x f -> case ts of 
            [] -> elimCuant (apsubsF f [(x, creaConst cn)]) (cn+1, fn, [])
            ts -> elimCuant (apsubsF f [(x, creaFun fn ts)]) (cn, fn+1, ts)
      _ -> form

--------------------------------------------
--Auxiliares que crean constantes y variables para eliminar los cuantificadores
creaConst::Int->Term
creaConst n = Fn ("c"++show (n)) []

creaFun::Int->[Term]->Term
creaFun n ts = Fn ("f"++show (n)) ts
--------------------------------------------

--Devuelve la forma normal Skolem, se da por hecho que se aplicó fnp                    
fns::Form->Form
fns f = elimCuant f (0,0,[])     


--Función que transforma una fórmula a FNC.
fnc::Form->Form
fnc form = case form of
    Or f1 f2 -> distr form
    And f1 f2 -> And (fnc f1) (fnc f2)
    _ -> form

--Distribuye una formula sobre la disyunción
distr::Form->Form
distr form = case form of
    Or f1 (And f2 f3) -> And (distr $ Or (distr f1) (distr f2)) (distr $ Or (distr f1) (distr f3))
    Or (And f1 f2) f3 -> And (distr $ Or (distr f1) (distr f3)) (distr $ Or (distr f2) (distr f3))
    And f1 f2 -> And (distr f1) (distr f2)
    _ -> form


--Nos devuelve la forma clausular de una fórmula
formClaus::Form->Form
formClaus = fnc . fns . fnp . fnn . recF

--Para que veas que sí funciona, la formClaus de esta fórmula es (salvo alpha-equivalencias):
-- ¬R(X0,f0(X0),X3,f2(X0,X3)) ∨ P(f1(X0))
form_ejem = All (X 0) $ Ex (X 1) $ Impl (Ex (X 3) $ All (X 4) $ Pr "R" [X 0,X 1,X 3,X 4]) (Ex (X 0) $ Pr "P" [X 0])

form_ejem_1 = All (X 0) $ Impl (Pr "P"  [X 0]) (All (X 0) $ Pr "Q" [X 0])

form_ejem_2 = Or (All (X 0) $ Pr "P"  [X 0]) (All (X 0) $ Pr "Q" [X 0])
