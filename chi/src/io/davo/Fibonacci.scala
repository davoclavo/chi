
package io.davo

import chisel3._

class Fibonacci(width: Int) extends Module {
  val io = IO(new Bundle {
                val out = Output(UInt(width.W))
              })

  // x_n = x_n-1 + x_n-2
  val x_1 = RegInit(1.U(width.W))
  val x_2 = RegInit(0.U(width.W))
  /*
    sum x_1 x_2
    --- --- ---
    1   1   0   | 1
    2   1   0   | 1
    3   2   1   | 2
    5   3   2   | 3
  */
  val sum = x_1 + x_2
  x_1 := sum
  x_2 := x_1
  io.out := x_1
}
