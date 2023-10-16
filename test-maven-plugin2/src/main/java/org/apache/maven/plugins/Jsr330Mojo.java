package org.apache.maven.plugins;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;

@Mojo( name = "hello", defaultPhase = LifecyclePhase.VALIDATE, requiresProject = false )
public class Jsr330Mojo
    extends AbstractMojo
{

    private Comp330 component;

    @Inject
    public Jsr330Mojo( @Named("one") Comp330 component )
    {
        this.component = component;
    }

    public void execute()
        throws MojoExecutionException
    {
        //
        // Say hello to the world, my little constructor injected component!
        //
        component.hello();
    }
}