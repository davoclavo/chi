
package io.davo

import utest._
import chiseltest._
import chisel3._

object FibonacciTest extends ChiselUtestTester {
  val tests: Tests = Tests {
    "fibonacci" - {
      println("Fibonacci")
      testCircuit(new Fibonacci(4)) { c =>
        c.io.out.expect(1.U)
        c.clock.step(1)
        c.io.out.expect(1.U)
        c.clock.step(1)
        c.io.out.expect(2.U)
        c.clock.step(1)
        c.io.out.expect(3.U)
        c.clock.step(1)
        c.io.out.expect(5.U)
        c.clock.step(1)
        c.io.out.expect(8.U)
        c.clock.step(1)
        c.io.out.expect(13.U)
      }
    }
  }
}
