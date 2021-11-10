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

public class LocationResult$$TypeAdapter implements TypeAdapter<LocationResult> {
  private Map<String, ChildElementBinder<LocationResult>> childElementBinders = new  HashMap<String, ChildElementBinder<LocationResult>>();

  public LocationResult$$TypeAdapter() {
    childElementBinders.put("header", new ChildElementBinder<LocationResult>() {
      @Override
      public void fromXml(XmlReader reader, TikXmlConfig config, LocationResult value) throws IOException {
        value.header = config.getTypeAdapter(LocationResult.header.class).fromXml(reader, config);
      }
    });
    childElementBinders.put("body", new ChildElementBinder<LocationResult>() {
      @Override
      public void fromXml(XmlReader reader, TikXmlConfig config, LocationResult value) throws IOException {
        value.body = config.getTypeAdapter(LocationResult.body.class).fromXml(reader, config);
      }
    });
  }

  @Override
  public LocationResult fromXml(XmlReader reader, TikXmlConfig config) throws IOException {
    LocationResult value = new LocationResult();
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
        ChildElementBinder<LocationResult> childElementBinder = childElementBinders.get(elementName);
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
  public void toXml(XmlWriter writer, TikXmlConfig config, LocationResult value, String overridingXmlElementTagName) throws IOException {
    if (value != null) {
      if (overridingXmlElementTagName == null) {
        writer.beginElement("locationResult");
      } else {
        writer.beginElement(overridingXmlElementTagName);
      }
      if (value.header != null) {
        config.getTypeAdapter(LocationResult.header.class).toXml(writer, config, value.header, "header");
      }
      if (value.body != null) {
        config.getTypeAdapter(LocationResult.body.class).toXml(writer, config, value.body, "body");
      }
      writer.endElement();
    }
  }
}
