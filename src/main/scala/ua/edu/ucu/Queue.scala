package ua.edu.ucu

trait Queue[+T] { // covariance
  def get:T
  def push[X >: T](x: X) // because input of a function is contravariant type
}
