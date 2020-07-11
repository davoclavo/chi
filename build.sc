import mill._, scalalib._
import coursier.maven.MavenRepository

object chi extends ScalaModule {
  def scalaVersion = "2.12.11"

  def scalacOptions = Seq(
    "-deprecation",
    "-feature",
    "-language:reflectiveCalls",
    "-Xsource:2.11"
  )

  def ivyDeps = Agg(
    ivy"edu.berkeley.cs::chisel3:3.3.2",
    ivy"edu.berkeley.cs::chisel-iotesters:1.4.1+",
    ivy"com.lihaoyi:::ammonite:2.1.4"
  )

  def repositories = super.repositories ++ Seq(
    MavenRepository("https://oss.sonatype.org/content/repositories/releases"),
    MavenRepository("https://oss.sonatype.org/content/repositories/snapshots")
  )

  object test extends Tests {
    def ivyDeps = Agg(
      ivy"edu.berkeley.cs::chiseltest:0.2.2"
    )

    def testFrameworks = Seq(
      "utest.runner.Framework"
    )
  }
}
