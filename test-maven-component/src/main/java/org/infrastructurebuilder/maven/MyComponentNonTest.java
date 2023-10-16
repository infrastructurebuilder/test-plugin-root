package org.infrastructurebuilder.maven;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.maven.project.MavenProject;
import org.eclipse.sisu.Typed;

@Named(MyComponentNonTest.JAVA)
@Typed(MyMavenComponent.class)
public class MyComponentNonTest extends MyMavenComponent {

  static final String JAVA = "java";

  @Inject
  public MyComponentNonTest() {
    int x = 0;
    x = 2;
  }

  @Override
  protected void addSourceFolderToProject(final MavenProject mavenProject) {
    mavenProject.addCompileSourceRoot(getOutputDirectory().getAbsolutePath());
  }

}
