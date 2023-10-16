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

import static org.junit.Assert.assertFalse;

import java.io.File;

import org.apache.maven.plugin.logging.Log;
import org.apache.maven.project.MavenProject;
import org.infrastructurebuilder.util.logging.LoggingMavenComponent;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CompFiltersTest {
  private final Logger logger = LoggerFactory.getLogger(getClass());
  private final Log log = new LoggingMavenComponent(logger);
  @Test
  public void dontAddSourceFolder() {
    final StringBuilder placeholder = new StringBuilder();
    final MyComponentNonTest jc = new MyComponentNonTest();
    jc.setLog(log);
    jc.setOutputDirectory(new File("."));
    File f = jc.getOutputDirectory();

    final MavenProject mock = new MavenProject();

    jc.addSourceFolderToProject(mock);
    assertFalse(mock.getCompileSourceRoots().contains(f));


  }
}
