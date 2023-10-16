package org.infrastructurebuilder.maven;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.maven.project.MavenProject;
import org.eclipse.sisu.Typed;

@Named(MyComponentTest.JAVA_TEST)
@Typed(MyMavenComponent.class)
public class MyComponentTest extends MyMavenComponent {

  static final String JAVA_TEST = "java-test";

  @Inject
  public MyComponentTest() {
  }
  @Override
  protected void addSourceFolderToProject(final MavenProject mavenProject) {
    mavenProject.addTestCompileSourceRoot(getOutputDirectory().getAbsolutePath());
  }

  @Override
  protected boolean isTestGeneration() {
    return true;
  }

}
