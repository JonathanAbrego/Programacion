
(*Facultad de Ciencias UNAM - Lógica Computacional 2017-2
      Noé Salomón Hernández Sánchez
      Albert M. Orozco Camacho
      C. Moisés Vázquez Reyes
      Diego Murillo Albarrán
      José Roberto Piche Limeta*)


Section LogicaProposicional.

Variables p q r s t u w:Prop.

Lemma ejem1 : p -> p.
Proof.
intros.
apply H.
(*trivial.*)
Qed.


Lemma ejem2 : ((p -> q) /\ p) -> q.
Proof.
intros.
destruct H.
apply H.
apply H0.
Qed.


Lemma ejem3 : p -> q -> p/\q.
Proof.
intros.
split.
apply H.
apply H0.
Qed.


Lemma ejem4 : (p->q) /\ (q->r) -> (p -> r).
Proof.
intros.
destruct H.
apply H1.
apply H.
trivial.
Qed.



Lemma ejem5 : (p -> r) -> (q -> r) -> (p \/ q -> r).
Proof.
intros.
destruct H1.
apply H.
trivial.
apply H0.
trivial.
Qed.


Lemma Ejem6 : p \/ q -> q \/ p.
Proof.
intros.
destruct H.
right;
trivial.
left;
trivial.
Qed.


Theorem Arg1: (p -> q /\ r) -> 
              (r \/ ~q -> s /\ t) ->
              ( t <-> u) -> (p -> u).
Proof.
(*intros.
apply H1.
assert (s /\ t).
apply H0.
assert (q /\ r).
apply H.
trivial.
destruct H3.
left.
trivial.
destruct H3.
trivial.*)

intros.
apply H in H2.
destruct H2.
assert (r\/~q).
left. trivial.
apply H0 in H4.
destruct H4.
apply H1. trivial.
Qed.


Lemma Contrapositiva: (~t -> ~s)->(s->t).
Admitted.

Theorem Arg3: (p <-> ~q /\ s) ->
              (p /\ (~t -> ~s)) -> ~q /\ t.
Proof.
intros.
destruct H0.
apply Contrapositiva in H1. 
split.
apply H in H0.
apply H0.
trivial.
apply H in H0.
apply H0.
Qed.


(*Ejercicios*)



Lemma ejer1 : p /\ q -> q /\ p.
Proof.
intros.
destruct H.
split.
apply H0.
apply H.
Qed.

Lemma ejer2 : p /\ (q /\ r) -> (p /\ q) /\ r.
Proof.
intros.
destruct H.
destruct H0.
split.
split.
apply H.
apply H0.
apply H1.
Qed.

Lemma ejer3 : (p -> q) /\ (p -> r) -> (p -> q /\ r).
Proof.
intros.
destruct H.
split.
apply H.
apply H0.
apply H1.
apply H0.
Qed.

Lemma ejer4 : (p \/ q) -> (p -> r) -> (q -> r) -> r.
Proof.
intros.
destruct H as [H2 | H3].
apply H0.
trivial.
apply H1.
trivial.
Qed.

Lemma ejer5 : (p -> q -> r) -> (p /\q -> r).
Proof.
intros.
apply H.
destruct H0.
trivial.
destruct H0.
trivial.
Qed.


Lemma ejer6 : (p \/ q) -> ( (p \/ (q -> r)) -> (p \/ r)).
Proof.
intros.
destruct H.
destruct H0.
left.
trivial.
left.
apply H.
destruct H0.
left. 
apply H0.
right.
apply H0.
trivial.
Qed.

Theorem ejer7: (p /\ q) -> 
              (r /\ ~s) ->
              (q -> p -> t) ->
              (t -> r -> s \/ w) -> w.  
Proof.
intros.
destruct H.
destruct H0.
elim H2.
destruct H2 as [H6 | H5].
apply H1.
apply H3.
apply H.
apply H0.
elim H4.
trivial.
intros.
trivial.
intros.
trivial.
apply H1.
apply H3.
apply H.
apply H0.
Qed.



End LogicaProposicional.





Section LogicaDePredicados.
Variables (A:Type) (a b: A) (P Q R : A -> Prop).

Lemma ejemp1 : (forall x, P x) -> P a.
Proof.
intros.
apply H.
Qed.



Lemma ejemp2 : (forall x, P x -> Q x) /\ P b ->  P b /\ Q b.
Proof.
intros.
destruct H.
split.
trivial.
apply H.
trivial.
Qed.

Lemma ejemp3 : P a -> (exists x, P x).
Proof.
intros.
exists a.
trivial.
Qed.


Lemma ejemp4 : (P a /\ R a) -> (forall x, R x -> Q x) -> (exists x, P x /\ Q x).

Proof.
intros.
exists a.
split.
apply H.
apply H0.
apply H.
Qed.



Lemma ejemp5 : (forall x, P x -> Q x) /\ (exists x, R x /\ P x) -> (exists x, Q x /\ R x).
Proof.
intros.
destruct H.
destruct H0 as [c E].
exists c.
split.
apply H.
apply E.
apply E.
Qed.




(*Ejercicios*)
Lemma ejerc1 : (forall x, P x -> Q x) /\ (forall x, Q x -> R x) -> P a -> Q a. 
Proof. 
intros.
destruct H.
apply H.
apply H0.
Qed.

Lemma ejerc2: (forall x, P x -> Q x) -> (forall y, P y -> (Q y \/ R y)).
Proof.
intros.
left.
apply H.
apply H0.
Qed.

Lemma ejerc3 : (forall x, P x -> Q x -> R x) -> (P a /\ Q a) -> (exists y, R y).
Proof.
intros.
exists a.
apply H.
destruct H0.
trivial.
destruct H0.
trivial.
Qed.

Lemma ejerc4 : (exists x, P x /\ Q x) -> (exists x, P x /\ exists y, Q y).
Proof.
intros.
destruct H.
destruct H.
exists x.
split.
apply H.
exists x.
apply H0.
Qed.

Lemma ejerc5 : (forall x, P x -> R x) -> (forall x, P x /\ Q x -> R x).
Proof.
intros.
apply H.
destruct H0.
apply H0.
Qed.

Lemma ejerc6 : (forall x, P x \/ Q x) -> (forall x, P x)\/(forall x, Q x).
Proof.
Admitted.

Lemma ejerc7 : (exists x, P x /\ Q a) /\ (forall x, P x -> R x) -> ( Q a /\ exists y, P y /\ R y).
Proof.
intros.
destruct H.
elim H.
intro x.
split.
apply H1.
exists x.
split.
destruct H1.
apply H1.
apply H0. 
destruct H1.
trivial.
Qed.






End LogicaDePredicados.




