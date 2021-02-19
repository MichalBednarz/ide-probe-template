import org.virtuslab.ideprobe._
import org.virtuslab.ideprobe.dependencies.IntelliJVersion
import org.virtuslab.ideprobe.junit4._
import org.junit.Test


class ProbeTest extends IdeProbeFixture {
  val config = Config.fromString(
    """
      |probe {
      | workspace.path = /home/mbednarz/hello-world-template
      | driver.vmOptions = ["-agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=5005"]
      | intellij.version = { build = 2020.1 }
      | resolvers.intellij.repository {
      |   uri = /home/mbednarz/cache
      |   group = com/jetbrains/intellij/idea
      |   artifact = ideaIC
      | }
      | paths {
      |   base = /home/mbednarz/
      | }
      |}
      |""".stripMargin)

  val fixture = fixtureFromConfig(config)

  @Test def test: Unit = fixture.run { intelliJ =>
    val projectRef = intelliJ.probe.openProject(intelliJ.workspace)
    val x = ""
    assert(true)
  }
}

/**
Installing IntelliJVersion(2020.1,None)
Fetching https://www.jetbrains.com/intellij-repository/releases/com/jetbrains/intellij/idea/ideaIC/2020.1/ideaIC-2020.1.zip into /home/mbednarz/cache/cb445bbf82fee3d708d877cfa80f27e6
Installed IntelliJVersion(2020.1,None)
Extracting jar:file:/home/mbednarz/.cache/coursier/v1/https/repo1.maven.org/maven2/org/virtuslab/ideprobe/driver_2.12/0.3.0/driver_2.12-0.3.0.jar!/ideprobe-0.3.0.zip from jar into /home/mbednarz/cache/99c9da48df07509a89e605562b3747de
Installed Bundled(ideprobe-0.3.0.zip)
 */