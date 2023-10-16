/**
 * Copyright © 2019 admin (admin@infrastructurebuilder.org)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.infrastructurebuilder.maven;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;
import org.apache.maven.shared.filtering.MavenFilteringException;
import org.apache.maven.shared.filtering.MavenResourcesExecution;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

public class Comp1Test extends AbstractBase {
  private MavenProject project;
  private Path tests;

  @Override
  public MavenProject getProject() throws Throwable {
    tests = getCopyOfTestingWorkingPath(Paths.get("test1"));
    project = CompProjectStub.createProjectForITExample(tests);
    return project;
  }

  public File getWorkDirectory() {
    return tests.resolve("target").resolve("generate-version").toFile();
  }

  @Test
  public void testExecute() throws Throwable {
    MyMavenComponent c = this.component;
    c.setOverriddenTemplateFile(null);

    c.execute();
    assertEquals(1, c.countCopiedFiles());

//    verify(filtering, times(1)).filterResources(any(MavenResourcesExecution.class));
//    verify(buildContext, times(1)).refresh(outputDirectory);
//    verify(getProject(), times(1)).addCompileSourceRoot(outputDirectory.getAbsolutePath());
  }

  @Test(expected = NullPointerException.class)
  public void testExecuteSetNullSource() throws MojoExecutionException, MavenFilteringException {
    this.component.setWorkDirectory(null);
  }

  @Test
  public void testGetOutputDirectory() {

    final File file = this.component.getOutputDirectory();
    assertNotNull(file);
    assertNotNull(file.getPath());
    assertTrue(file.getPath().contains("generated-version-templates"));
  }

  @Override
  protected MyMavenComponent getComponent() {
    MyComponentNonTest jc = new MyComponentNonTest();
    jc.setLog(getLog());
    return jc;
  }
}