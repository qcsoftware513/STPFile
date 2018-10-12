/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.billman.stp;

import java.awt.Component;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.swing.JComponent;
import javax.swing.event.ChangeListener;
import org.netbeans.api.project.Project;
import org.netbeans.api.project.SourceGroup;
import org.netbeans.api.project.Sources;
import org.netbeans.spi.project.ui.templates.support.Templates;
import org.openide.WizardDescriptor;
import org.openide.filesystems.FileObject;
import org.openide.loaders.DataFolder;
import org.openide.loaders.DataObject;
import org.openide.util.NbBundle.Messages;

// TODO define position attribute
@Messages("StpWizardIterator_displayName=Stored Procedure")
public final class StpWizardIterator implements WizardDescriptor.InstantiatingIterator<WizardDescriptor>
{

  private int index;

  private WizardDescriptor wizard;
  private List<WizardDescriptor.Panel<WizardDescriptor>> panels;
  private WizardDescriptor.Panel chooserPanel;

  private List<WizardDescriptor.Panel<WizardDescriptor>> getPanels()
  {
    if(panels == null)
    {
      Project project = Templates.getProject(wizard);
      //Templates.getTargetFolder(wizard).
      Sources sources = (Sources) project.getLookup().lookup(Sources.class);
      SourceGroup[] groups = sources.getSourceGroups(Sources.TYPE_GENERIC);
      //JavaTemplates.createPackageChooser(project, groups, new TrgWizardPanel1());
      chooserPanel = Templates.buildSimpleTargetChooser(project, groups).bottomPanel(new StpWizardPanel1()).create();

      panels = new ArrayList<WizardDescriptor.Panel<WizardDescriptor>>();
      panels.add(chooserPanel);
      String[] steps = createSteps();
      for(int i = 0; i < panels.size(); i++)
      {
        Component c = panels.get(i).getComponent();
        if(steps[i] == null)
        {
          // Default step name to component name of panel. Mainly
          // useful for getting the name of the target chooser to
          // appear in the list of steps.
          steps[i] = c.getName();
        }
        if(c instanceof JComponent)
        { // assume Swing components
          JComponent jc = (JComponent) c;
          jc.putClientProperty(WizardDescriptor.PROP_CONTENT_SELECTED_INDEX, i);
          jc.putClientProperty(WizardDescriptor.PROP_CONTENT_DATA, steps);
          jc.putClientProperty(WizardDescriptor.PROP_AUTO_WIZARD_STYLE, true);
          jc.putClientProperty(WizardDescriptor.PROP_CONTENT_DISPLAYED, true);
          jc.putClientProperty(WizardDescriptor.PROP_CONTENT_NUMBERED, true);
        }
      }
    }
    return panels;
  }

  @Override
  public Set<?> instantiate() throws IOException
  {
    String paramInfo = (String)wizard.getProperty(StpVisualPanel1.PARAMETER_INFO);

    Map args = new HashMap();
    args.put("paramInfo", paramInfo);

    FileObject template = Templates.getTemplate(wizard);
    DataObject dTemplate = DataObject.find(template);//Get the package:
    FileObject dir = Templates.getTargetFolder(wizard);
    DataFolder df = DataFolder.findFolder(dir);//Get the class:
    String targetName = Templates.getTargetName(wizard);//Define the template from the above,
    //passing the package, the file name, and the map of strings to the template:
    DataObject dobj = dTemplate.createFromTemplate(df, targetName, args);//Obtain a FileObject:
    FileObject createdFile = dobj.getPrimaryFile();//Create the new file:
    return Collections.singleton(createdFile);
  }

  @Override
  public void initialize(WizardDescriptor wizard)
  {
    this.wizard = wizard;
  }

  @Override
  public void uninitialize(WizardDescriptor wizard)
  {
    panels = null;
  }

  @Override
  public WizardDescriptor.Panel<WizardDescriptor> current()
  {
    return getPanels().get(index);
  }

  @Override
  public String name()
  {
    return index + 1 + ". from " + getPanels().size();
  }

  @Override
  public boolean hasNext()
  {
    return index < getPanels().size() - 1;
  }

  @Override
  public boolean hasPrevious()
  {
    return index > 0;
  }

  @Override
  public void nextPanel()
  {
    if(!hasNext())
    {
      throw new NoSuchElementException();
    }
    index++;
  }

  @Override
  public void previousPanel()
  {
    if(!hasPrevious())
    {
      throw new NoSuchElementException();
    }
    index--;
  }

  // If nothing unusual changes in the middle of the wizard, simply:
  @Override
  public void addChangeListener(ChangeListener l)
  {
  }

  @Override
  public void removeChangeListener(ChangeListener l)
  {
  }
  // If something changes dynamically (besides moving between panels), e.g.
  // the number of panels changes in response to user input, then use
  // ChangeSupport to implement add/removeChangeListener and call fireChange
  // when needed

  // You could safely ignore this method. Is is here to keep steps which were
  // there before this wizard was instantiated. It should be better handled
  // by NetBeans Wizard API itself rather than needed to be implemented by a
  // client code.
  private String[] createSteps()
  {
    String[] beforeSteps = (String[]) wizard.getProperty("WizardPanel_contentData");
    assert beforeSteps != null : "This wizard may only be used embedded in the template wizard";
    String[] res = new String[(beforeSteps.length - 1) + panels.size()];
    for(int i = 0; i < res.length; i++)
    {
      if(i < (beforeSteps.length - 1))
      {
        res[i] = beforeSteps[i];
      }
      else
      {
        res[i] = panels.get(i - beforeSteps.length + 1).getComponent().getName();
      }
    }
    return res;
  }

}
