{-
   Lógica computacional 2017-1
      Noé Salomón Hernández Sánchez
      Albert M. Orozco Camacho
      C. Moisés Vázquez Reyes
      Diego Murillo Albarrán
      José Roberto Piche Limeta

   Práctica 1

-}

import Data.List

miCuenta :: Int
miCuenta = 412049725

--INTERPRETACIONES
data Form = T | F | Var String | Neg Form | Conj Form Form | Disy Form Form | Imp Form Form | DImp Form Form deriving Eq
type Estado = [String]

instance Show Form where
   --Atómicas
   show T = "⊤"
   show F = "⊥"
   --Variables
   show (Var x) = x
   --Negación
   show (Neg T) = "¬⊤"
   show (Neg F) = "¬⊥"
   show (Neg v@(Var x)) = "¬"++show v
   show (Neg f@(Neg p)) = "¬"++show f
   show (Neg p) = "¬("++show p++")"
   --Conjunción
   show (Conj v1@(Var p) v2@(Var q)) = show v1++" ∧ "++show v2
   show (Conj f1 v2@(Var q)) = case f1 of 
                               Neg f -> show f1++" ∧ "++show v2
                               _ -> "("++show f1++") ∧ "++show v2
   show (Conj v1@(Var p) f2) = case f2 of 
                               Neg f -> show v1++" ∧ "++show f2
                               _ -> show v1++" ∧ ("++show f2++")"
   show (Conj n1@(Neg f1) n2@(Neg f2)) = show n1++" ∧ "++show n2
   show (Conj n1@(Neg f1) f2) = show n1++" ∧ ("++show f2++")"
   show (Conj f1 n2@(Neg f2)) = "("++show f1++") ∧ "++show n2
   show (Conj f1 f2) = "("++show f1++") ∧ ("++show f2++")"
   --Disyunción
   show (Disy v1@(Var p) v2@(Var q)) = show v1++" ∨ "++show v2
   show (Disy f1 v2@(Var q)) = case f1 of 
                               Neg f -> show f1++" ∨ "++show v2
                               _ -> "("++show f1++") ∨ "++show v2
   show (Disy v1@(Var p) f2) = case f2 of 
                               Neg f -> show v1++" ∨ "++show f2
                               _ -> show v1++" ∨ ("++show f2++")"
   show (Disy n1@(Neg f1) n2@(Neg f2)) = show n1++" ∨ "++show n2
   show (Disy n1@(Neg f1) f2) = show n1++" ∨ ("++show f2++")"
   show (Disy f1 n2@(Neg f2)) = "("++show f1++") ∨ "++show n2
   show (Disy f1 f2) = "("++show f1++") ∨ ("++show f2++")"
   --Implicación
   show (Imp v1@(Var p) v2@(Var q)) = show v1++" ⟶ "++show v2
   show (Imp f1 v2@(Var q)) = case f1 of 
                               Neg f -> show f1++" ⟶ "++show v2
                               _ -> "("++show f1++") ⟶ "++show v2
   show (Imp v1@(Var p) f2) = case f2 of 
                               Neg f -> show v1++" ⟶ "++show f2
                               _ -> show v1++" ⟶ ("++show f2++")"
   show (Imp n1@(Neg f1) n2@(Neg f2)) = show n1++" ⟶ "++show n2
   show (Imp n1@(Neg f1) f2) = show n1++" ⟶ ("++show f2++")"
   show (Imp f1 n2@(Neg f2)) = "("++show f1++") ⟶ "++show n2
   show (Imp f1 f2) = "("++show f1++") ⟶ ("++show f2++")"
   --Doble implicación
   show (DImp v1@(Var p) v2@(Var q)) = show v1++" ⟷ "++show v2
   show (DImp f1 v2@(Var q)) = case f1 of 
                               Neg f -> show f1++" ⟷ "++show v2
                               _ -> "("++show f1++") ⟷ "++show v2
   show (DImp v1@(Var p) f2) = case f2 of 
                               Neg f -> show v1++" ⟷ "++show f2
                               _ -> show v1++" ⟷ ("++show f2++")"
   show (DImp n1@(Neg f1) n2@(Neg f2)) = show n1++" ⟷ "++show n2
   show (DImp n1@(Neg f1) f2) = show n1++" ⟷ ("++show f2++")"
   show (DImp f1 n2@(Neg f2)) = "("++show f1++") ⟷ "++show n2
   show (DImp f1 f2) = "("++show f1++") ⟷ ("++show f2++")"       


interp::Estado->Form->Bool
interp _ T = True
interp _ F = False 
interp a (Var x) = (x `elem` a)
interp a (Neg f) = not (interp a f)
interp a (Conj f g) = (interp a f) && (interp a g)
interp a (Disy f g) = (interp a f) || (interp a g)
interp a (Imp f g) = (interp a (Neg f)) || (interp a g)
interp a (DImp f g) = (interp a (Imp f g)) && (interp a (Imp g f))

vars::Form->[String]
vars T = []
vars F = []
vars (Var x) = [x]
vars (Neg f) = nub (vars f)
vars (Conj f g) = nub (vars f ++ vars g)
vars (Disy f g) = nub (vars f ++ vars g)
vars (Imp f g) = nub (vars f ++ vars g)
vars (DImp f g) = nub (vars f ++ vars g)



potencia::[a]->[[a]]
potencia [] = [[]]
potencia (x:xs) = map (x:) l ++ l
                  where l = potencia xs 

estados::Form->[Estado]
estados f = potencia (vars f)


tautologia::Form->Bool
tautologia f = and [interp a f | a <- estados f]


--TABLEUAX SEMÁNTICOS

data Tableaux = Void | R1 [Form] Tableaux | R2 Tableaux Tableaux | Tache | Bolita deriving Show
   

creaTableaux::[Form]->Tableaux
creaTableaux = error "Te toca"
                                                                  
cerrado::Tableaux->Bool
cerrado = error "Te toca"  
                                                            

tautologia_tableaux::Form->Bool
tautologia_tableaux = error "Te toca"

--Algunas fórmulas de prueba. 
--Puedes comprobar que f <--> f1 <--> f2
--Puedes comprobar que g <--> g1 <--> g2


f = Disy (Neg $ Imp (Var "w") (Var "e")) (Neg $ Disy (DImp (Neg $ Var "s") (Var "w")) (Conj (Var "e") (Var "s")))
f1 = Conj (Conj (Conj (Conj (Disy (Disy (Neg $ Var "e") (Var "s")) (Neg $ Var "w")) (Disy (Neg $ Var "s") (Var "w"))) (Disy (Disy (Neg $ Var "e") (Neg $ Var "s")) (Var "w"))) (Disy (Disy (Var "w") (Neg $ Var "e")) (Neg $ Var "s"))) (Disy (Neg $ Var "e") (Neg $ Var "s"))                                                             
f2 = Disy (Disy (Disy (Conj (Var "w") (Neg $ Var "e")) (Conj (Conj (Neg $ Var "w") (Neg $ Var "s")) (Neg $ Var "e"))) (Conj (Neg $ Var "w") (Neg $ Var "s"))) (Conj (Conj (Var "s") (Var "w")) (Neg $ Var "e"))

g = Disy (Neg $ Imp (Var "w") (Var "e")) (Neg $ Disy (DImp (Neg $ Var "s") (Var "w")) (Conj (Var "e") (Var "s")))
g1 = Conj (Conj (Conj (Conj (Disy (Var "w") (Neg $ Var "s")) (Disy (Disy (Neg $ Var "e") (Neg $ Var "s")) (Var "w"))) (Disy (Disy (Neg $ Var "e") (Neg $ Var "w")) (Var "s"))) (Disy (Disy (Var "w") (Neg $ Var "e")) (Neg $ Var "s"))) (Disy (Neg $ Var "e") (Neg $ Var "s"))
g2 = Disy (Disy (Disy (Conj (Var "w") (Neg $ Var "e")) (Conj (Conj (Neg $ Var "s") (Neg $ Var "w")) (Neg $ Var "e"))) (Conj (Neg $ Var "s") (Neg $ Var "w"))) (Conj (Conj (Var "w") (Var "s")) (Neg $ Var "e"))





