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

public class body$$TypeAdapter implements TypeAdapter<LocationResult.body> {
  private Map<String, ChildElementBinder<LocationResult.body>> childElementBinders = new  HashMap<String, ChildElementBinder<LocationResult.body>>();

  public body$$TypeAdapter() {
    childElementBinders.put("pageNo", new ChildElementBinder<LocationResult.body>() {
      @Override
      public void fromXml(XmlReader reader, TikXmlConfig config, LocationResult.body value) throws IOException {
        while(reader.hasAttribute()) {
          String attributeName = reader.nextAttributeName();
          if (config.exceptionOnUnreadXml() && !attributeName.startsWith("xmlns")) {
            throw new IOException("Unread attribute '"+ attributeName +"' at path "+ reader.getPath());
          }
          reader.skipAttributeValue();
        }
        value.pageNo = reader.nextTextContentAsInt();
      }
    });
    childElementBinders.put("totalCount", new ChildElementBinder<LocationResult.body>() {
      @Override
      public void fromXml(XmlReader reader, TikXmlConfig config, LocationResult.body value) throws IOException {
        while(reader.hasAttribute()) {
          String attributeName = reader.nextAttributeName();
          if (config.exceptionOnUnreadXml() && !attributeName.startsWith("xmlns")) {
            throw new IOException("Unread attribute '"+ attributeName +"' at path "+ reader.getPath());
          }
          reader.skipAttributeValue();
        }
        value.totalCount = reader.nextTextContentAsInt();
      }
    });
    childElementBinders.put("items", new ChildElementBinder<LocationResult.body>() {
      @Override
      public void fromXml(XmlReader reader, TikXmlConfig config, LocationResult.body value) throws IOException {
        value.items = config.getTypeAdapter(LocationResult.body.items.class).fromXml(reader, config);
      }
    });
    childElementBinders.put("numOfRows", new ChildElementBinder<LocationResult.body>() {
      @Override
      public void fromXml(XmlReader reader, TikXmlConfig config, LocationResult.body value) throws IOException {
        while(reader.hasAttribute()) {
          String attributeName = reader.nextAttributeName();
          if (config.exceptionOnUnreadXml() && !attributeName.startsWith("xmlns")) {
            throw new IOException("Unread attribute '"+ attributeName +"' at path "+ reader.getPath());
          }
          reader.skipAttributeValue();
        }
        value.numOfRows = reader.nextTextContentAsInt();
      }
    });
  }

  @Override
  public LocationResult.body fromXml(XmlReader reader, TikXmlConfig config) throws IOException {
    LocationResult.body value = new LocationResult.body();
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
        ChildElementBinder<LocationResult.body> childElementBinder = childElementBinders.get(elementName);
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
  public void toXml(XmlWriter writer, TikXmlConfig config, LocationResult.body value, String overridingXmlElementTagName) throws IOException {
    if (value != null) {
      if (overridingXmlElementTagName == null) {
        writer.beginElement("body");
      } else {
        writer.beginElement(overridingXmlElementTagName);
      }
      writer.beginElement("pageNo");
      writer.textContent(value.pageNo);
      writer.endElement();
      writer.beginElement("totalCount");
      writer.textContent(value.totalCount);
      writer.endElement();
      if (value.items != null) {
        config.getTypeAdapter(LocationResult.body.items.class).toXml(writer, config, value.items, "items");
      }
      writer.beginElement("numOfRows");
      writer.textContent(value.numOfRows);
      writer.endElement();
      writer.endElement();
    }
  }
}
