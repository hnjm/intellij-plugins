package com.intellij.tapestry.intellij;

import com.intellij.openapi.components.ProjectComponent;
import com.intellij.openapi.project.Project;
import com.intellij.tapestry.core.log.Logger;
import com.intellij.tapestry.core.log.LoggerFactory;
import com.intellij.tapestry.intellij.toolwindow.TapestryToolWindow;
import com.intellij.tapestry.intellij.toolwindow.TapestryToolWindowFactory;
import org.jetbrains.annotations.NotNull;

public class TapestryProjectSupportLoader implements ProjectComponent {

  private static final Logger LOGGER = LoggerFactory.getInstance().getLogger(TapestryProjectSupportLoader.class);

  private Project myProject;
  private TapestryToolWindow myTapestryToolwindow;

  public TapestryProjectSupportLoader(Project project) {
    myProject = project;
  }

  public void initComponent() {
  }

  public void disposeComponent() {
  }

  @NotNull
  public String getComponentName() {
    return TapestryProjectSupportLoader.class.getName();
  }

  public void projectOpened() {
    new TapestryToolWindowFactory().configureToolWindow(myProject);

    //if (TapestryUtils.getAllTapestryModules(myProject).length > 0) {
    //
    //  StartupManager.getInstance(myProject).runWhenProjectIsInitialized(new Runnable() {
    //    public void run() {
    //      try {
    //        addCompilerResources();
    //      }
    //      catch (Exception ex) {
    //        LOGGER.warn(ex);
    //      }
    //    }
    //  });
    //}
  }


  public TapestryToolWindow getTapestryToolWindow() {
    return myTapestryToolwindow;
  }

  public void projectClosed() {
  }

  //public void addCompilerResources() throws MalformedPatternException {
  //  final CompilerConfigurationImpl compilerConfiguration = (CompilerConfigurationImpl)myProject.getComponent(CompilerConfiguration.class);
  //  String[] filePatterns = compilerConfiguration.getResourceFilePatterns();
  //
  //  final String tapestryFilePattern = "?*." + TapestryConstants.TEMPLATE_FILE_EXTENSION;
  //  if (Arrays.binarySearch(filePatterns, tapestryFilePattern) < 0) {
  //    compilerConfiguration.addResourceFilePattern(tapestryFilePattern);
  //  }
  //}
  //
  public void initTapestryToolWindow(@NotNull TapestryToolWindow tapestryToolWindow) {
    myTapestryToolwindow = tapestryToolWindow;
  }
}
