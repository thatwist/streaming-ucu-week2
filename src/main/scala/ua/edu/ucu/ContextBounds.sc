def plus[A](a1: A, a2: A): A = ???    	// plus: [A](a1: A, a2: A)A

trait Plus[A] {
  def plus(a2: A): A
}  						// defined trait Plus
def plus[A <: Plus[A]](a1: A, a2: A): A = a1.plus(a2)
// plus: [A <: Plus[A]](a1: A, a2: A)A

trait PlusBi[A] {
  def plus(a1: A, a2: A): A
} // defined trait Plus2
def plus[A: PlusBi](a1: A, a2: A): A = implicitly[PlusBi[A]].plus(a1, a2)
// plus: [A](a1: A, a2: A)(implicit evidence$1: PlusBi[A])A

def plus[A](a1: A, a2: A)(implicit ev1: PlusBi[A]): A = ev1.plus(a1, a2)
// plus: [A](a1: A, a2: A)(implicit evidence$1: PlusBi[A])A
