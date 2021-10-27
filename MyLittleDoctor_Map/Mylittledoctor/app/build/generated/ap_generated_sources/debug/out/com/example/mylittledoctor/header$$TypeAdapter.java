package com.example.mylittledoctor;

import com.tickaroo.tikxml.TikXmlConfig;
import com.tickaroo.tikxml.XmlReader;
import com.tickaroo.tikxml.XmlWriter;
import com.tickaroo.tikxml.typeadapter.ChildElementBinder;
import com.tickaroo.tikxml.typeadapter.TypeAdapter;
import java.io.IOException;
import java.lang.Override;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;

public class header$$TypeAdapter implements TypeAdapter<header> {
  private Map<String, ChildElementBinder<header>> childElementBinders = new  HashMap<String, ChildElementBinder<header>>();

  public header$$TypeAdapter() {
    childElementBinders.put("resultCode", new ChildElementBinder<header>() {
      @Override
      public void fromXml(XmlReader reader, TikXmlConfig config, header value) throws IOException {
        while(reader.hasAttribute()) {
          String attributeName = reader.nextAttributeName();
          if (config.exceptionOnUnreadXml() && !attributeName.startsWith("xmlns")) {
            throw new IOException("Unread attribute '"+ attributeName +"' at path "+ reader.getPath());
          }
          reader.skipAttributeValue();
        }
        value.resultCode = reader.nextTextContentAsInt();
      }
    });
    childElementBinders.put("resultMsg", new ChildElementBinder<header>() {
      @Override
      public void fromXml(XmlReader reader, TikXmlConfig config, header value) throws IOException {
        while(reader.hasAttribute()) {
          String attributeName = reader.nextAttributeName();
          if (config.exceptionOnUnreadXml() && !attributeName.startsWith("xmlns")) {
            throw new IOException("Unread attribute '"+ attributeName +"' at path "+ reader.getPath());
          }
          reader.skipAttributeValue();
        }
        value.resultMsg = reader.nextTextContent();
      }
    });
  }

  @Override
  public header fromXml(XmlReader reader, TikXmlConfig config) throws IOException {
    header value = new header();
    while(reader.hasAttribute()) {
      String attributeName = reader.nextAttributeName();
      if (config.exceptionOnUnreadXml() && !attributeName.startsWith("xmlns")) {
        throw new IOException("Could not map the xml attribute with the name '"+attributeName+"' at path "+reader.getPath()+" to java class. Have you annotated such a field in your java class to map this xml attribute? Otherwise you can turn this error message off with TikXml.Builder().exceptionOnUnreadXml(false).build().");
      }
      reader.skipAttributeValue();
    }
    while(true) {
      if (reader.hasElement()) {
        reader.beginElement();
        String elementName = reader.nextElementName();
        ChildElementBinder<header> childElementBinder = childElementBinders.get(elementName);
        if (childElementBinder != null) {
          childElementBinder.fromXml(reader, config, value);
          reader.endElement();
        } else if (config.exceptionOnUnreadXml()) {
          throw new IOException("Could not map the xml element with the tag name <" + elementName + "> at path '" + reader.getPath()+"' to java class. Have you annotated such a field in your java class to map this xml attribute? Otherwise you can turn this error message off with TikXml.Builder().exceptionOnUnreadXml(false).build().");
        } else {
          reader.skipRemainingElement();
        }
      } else if (reader.hasTextContent()) {
        if (config.exceptionOnUnreadXml()) {
          throw new IOException("Could not map the xml element's text content at path '"+reader.getPath()+" to java class. Have you annotated such a field in your java class to map the xml element's text content? Otherwise you can turn this error message off with TikXml.Builder().exceptionOnUnreadXml(false).build().");
        }
        reader.skipTextContent();
      } else {
        break;
      }
    }
    return value;
  }

  @Override
  public void toXml(XmlWriter writer, TikXmlConfig config, header value, String overridingXmlElementTagName) throws IOException {
    if (value != null) {
      if (overridingXmlElementTagName == null) {
        writer.beginElement("header");
      } else {
        writer.beginElement(overridingXmlElementTagName);
      }
      writer.beginElement("resultCode");
      writer.textContent(value.resultCode);
      writer.endElement();
      if (value.resultMsg != null) {
        writer.beginElement("resultMsg");
        if (value.resultMsg != null) {
          writer.textContent(value.resultMsg);
        }
        writer.endElement();
      }
      writer.endElement();
    }
  }
}
