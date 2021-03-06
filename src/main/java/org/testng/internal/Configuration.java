package org.testng.internal;

import org.testng.IConfigurable;
import org.testng.IConfigurationListener;
import org.testng.IExecutionListener;
import org.testng.IHookable;
import org.testng.ITestObjectFactory;
import org.testng.collections.Lists;
import org.testng.internal.annotations.DefaultAnnotationTransformer;
import org.testng.internal.annotations.IAnnotationFinder;
import org.testng.internal.annotations.JDK15AnnotationFinder;

import java.util.List;

public class Configuration implements IConfiguration {

  IAnnotationFinder m_annotationFinder;
  ITestObjectFactory m_objectFactory;
  IHookable m_hookable;
  IConfigurable m_configurable;
  List<IExecutionListener> m_executionListeners = Lists.newArrayList();
  private List<IConfigurationListener> m_configurationListeners = Lists.newArrayList();

  public Configuration() {
    init(new JDK15AnnotationFinder(new DefaultAnnotationTransformer()));
  }

  public Configuration(IAnnotationFinder finder) {
    init(finder);
  }

  private void init(IAnnotationFinder finder) {
    m_annotationFinder = finder;
  }

  @Override
  public IAnnotationFinder getAnnotationFinder() {
    return m_annotationFinder;
  }

  public void setAnnotationFinder(IAnnotationFinder finder) {
    m_annotationFinder = finder;
  }

  @Override
  public ITestObjectFactory getObjectFactory() {
    return m_objectFactory;
  }

  @Override
  public void setObjectFactory(ITestObjectFactory factory) {
    m_objectFactory = factory;
  }

  @Override
  public IHookable getHookable() {
    return m_hookable;
  }

  @Override
  public void setHookable(IHookable h) {
    m_hookable = h;
  }

  @Override
  public IConfigurable getConfigurable() {
    return m_configurable;
  }

  @Override
  public void setConfigurable(IConfigurable c) {
    m_configurable = c;
  }

  public List<IExecutionListener> getExecutionListeners() {
    return m_executionListeners;
  }

  public void addExecutionListener(IExecutionListener l) {
    m_executionListeners.add(l);
  }

  @Override
  public List<IConfigurationListener> getConfigurationListeners() {
    return Lists.newArrayList(m_configurationListeners);
  }

  @Override
  public void addConfigurationListener(IConfigurationListener cl) {
    m_configurationListeners.add(cl);
  }
}