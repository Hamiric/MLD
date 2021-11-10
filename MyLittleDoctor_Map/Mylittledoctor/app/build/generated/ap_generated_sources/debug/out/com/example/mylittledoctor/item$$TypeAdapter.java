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

public class item$$TypeAdapter implements TypeAdapter<LocationResult.body.items.item> {
  private Map<String, ChildElementBinder<LocationResult.body.items.item>> childElementBinders = new  HashMap<String, ChildElementBinder<LocationResult.body.items.item>>();

  public item$$TypeAdapter() {
    childElementBinders.put("rnum", new ChildElementBinder<LocationResult.body.items.item>() {
      @Override
      public void fromXml(XmlReader reader, TikXmlConfig config, LocationResult.body.items.item value) throws IOException {
        while(reader.hasAttribute()) {
          String attributeName = reader.nextAttributeName();
          if (config.exceptionOnUnreadXml() && !attributeName.startsWith("xmlns")) {
            throw new IOException("Unread attribute '"+ attributeName +"' at path "+ reader.getPath());
          }
          reader.skipAttributeValue();
        }
        value.rnum = reader.nextTextContentAsInt();
      }
    });
    childElementBinders.put("distance", new ChildElementBinder<LocationResult.body.items.item>() {
      @Override
      public void fromXml(XmlReader reader, TikXmlConfig config, LocationResult.body.items.item value) throws IOException {
        while(reader.hasAttribute()) {
          String attributeName = reader.nextAttributeName();
          if (config.exceptionOnUnreadXml() && !attributeName.startsWith("xmlns")) {
            throw new IOException("Unread attribute '"+ attributeName +"' at path "+ reader.getPath());
          }
          reader.skipAttributeValue();
        }
        value.distance = reader.nextTextContentAsDouble();
      }
    });
    childElementBinders.put("latitude", new ChildElementBinder<LocationResult.body.items.item>() {
      @Override
      public void fromXml(XmlReader reader, TikXmlConfig config, LocationResult.body.items.item value) throws IOException {
        while(reader.hasAttribute()) {
          String attributeName = reader.nextAttributeName();
          if (config.exceptionOnUnreadXml() && !attributeName.startsWith("xmlns")) {
            throw new IOException("Unread attribute '"+ attributeName +"' at path "+ reader.getPath());
          }
          reader.skipAttributeValue();
        }
        value.latitude = reader.nextTextContentAsDouble();
      }
    });
    childElementBinders.put("cnt", new ChildElementBinder<LocationResult.body.items.item>() {
      @Override
      public void fromXml(XmlReader reader, TikXmlConfig config, LocationResult.body.items.item value) throws IOException {
        while(reader.hasAttribute()) {
          String attributeName = reader.nextAttributeName();
          if (config.exceptionOnUnreadXml() && !attributeName.startsWith("xmlns")) {
            throw new IOException("Unread attribute '"+ attributeName +"' at path "+ reader.getPath());
          }
          reader.skipAttributeValue();
        }
        value.cnt = reader.nextTextContentAsInt();
      }
    });
    childElementBinders.put("dutyDivName", new ChildElementBinder<LocationResult.body.items.item>() {
      @Override
      public void fromXml(XmlReader reader, TikXmlConfig config, LocationResult.body.items.item value) throws IOException {
        while(reader.hasAttribute()) {
          String attributeName = reader.nextAttributeName();
          if (config.exceptionOnUnreadXml() && !attributeName.startsWith("xmlns")) {
            throw new IOException("Unread attribute '"+ attributeName +"' at path "+ reader.getPath());
          }
          reader.skipAttributeValue();
        }
        value.dutyDivName = reader.nextTextContent();
      }
    });
    childElementBinders.put("dutyDiv", new ChildElementBinder<LocationResult.body.items.item>() {
      @Override
      public void fromXml(XmlReader reader, TikXmlConfig config, LocationResult.body.items.item value) throws IOException {
        while(reader.hasAttribute()) {
          String attributeName = reader.nextAttributeName();
          if (config.exceptionOnUnreadXml() && !attributeName.startsWith("xmlns")) {
            throw new IOException("Unread attribute '"+ attributeName +"' at path "+ reader.getPath());
          }
          reader.skipAttributeValue();
        }
        value.dutyDiv = reader.nextTextContent();
      }
    });
    childElementBinders.put("dutyAddr", new ChildElementBinder<LocationResult.body.items.item>() {
      @Override
      public void fromXml(XmlReader reader, TikXmlConfig config, LocationResult.body.items.item value) throws IOException {
        while(reader.hasAttribute()) {
          String attributeName = reader.nextAttributeName();
          if (config.exceptionOnUnreadXml() && !attributeName.startsWith("xmlns")) {
            throw new IOException("Unread attribute '"+ attributeName +"' at path "+ reader.getPath());
          }
          reader.skipAttributeValue();
        }
        value.dutyAddr = reader.nextTextContent();
      }
    });
    childElementBinders.put("dutyLvkl", new ChildElementBinder<LocationResult.body.items.item>() {
      @Override
      public void fromXml(XmlReader reader, TikXmlConfig config, LocationResult.body.items.item value) throws IOException {
        while(reader.hasAttribute()) {
          String attributeName = reader.nextAttributeName();
          if (config.exceptionOnUnreadXml() && !attributeName.startsWith("xmlns")) {
            throw new IOException("Unread attribute '"+ attributeName +"' at path "+ reader.getPath());
          }
          reader.skipAttributeValue();
        }
        value.dutyLvkl = reader.nextTextContentAsInt();
      }
    });
    childElementBinders.put("dutyName", new ChildElementBinder<LocationResult.body.items.item>() {
      @Override
      public void fromXml(XmlReader reader, TikXmlConfig config, LocationResult.body.items.item value) throws IOException {
        while(reader.hasAttribute()) {
          String attributeName = reader.nextAttributeName();
          if (config.exceptionOnUnreadXml() && !attributeName.startsWith("xmlns")) {
            throw new IOException("Unread attribute '"+ attributeName +"' at path "+ reader.getPath());
          }
          reader.skipAttributeValue();
        }
        value.dutyName = reader.nextTextContent();
      }
    });
    childElementBinders.put("hpid", new ChildElementBinder<LocationResult.body.items.item>() {
      @Override
      public void fromXml(XmlReader reader, TikXmlConfig config, LocationResult.body.items.item value) throws IOException {
        while(reader.hasAttribute()) {
          String attributeName = reader.nextAttributeName();
          if (config.exceptionOnUnreadXml() && !attributeName.startsWith("xmlns")) {
            throw new IOException("Unread attribute '"+ attributeName +"' at path "+ reader.getPath());
          }
          reader.skipAttributeValue();
        }
        value.hpid = reader.nextTextContent();
      }
    });
    childElementBinders.put("dutyFax", new ChildElementBinder<LocationResult.body.items.item>() {
      @Override
      public void fromXml(XmlReader reader, TikXmlConfig config, LocationResult.body.items.item value) throws IOException {
        while(reader.hasAttribute()) {
          String attributeName = reader.nextAttributeName();
          if (config.exceptionOnUnreadXml() && !attributeName.startsWith("xmlns")) {
            throw new IOException("Unread attribute '"+ attributeName +"' at path "+ reader.getPath());
          }
          reader.skipAttributeValue();
        }
        value.dutyFax = reader.nextTextContent();
      }
    });
    childElementBinders.put("startTime", new ChildElementBinder<LocationResult.body.items.item>() {
      @Override
      public void fromXml(XmlReader reader, TikXmlConfig config, LocationResult.body.items.item value) throws IOException {
        while(reader.hasAttribute()) {
          String attributeName = reader.nextAttributeName();
          if (config.exceptionOnUnreadXml() && !attributeName.startsWith("xmlns")) {
            throw new IOException("Unread attribute '"+ attributeName +"' at path "+ reader.getPath());
          }
          reader.skipAttributeValue();
        }
        value.startTime = reader.nextTextContentAsInt();
      }
    });
    childElementBinders.put("endTime", new ChildElementBinder<LocationResult.body.items.item>() {
      @Override
      public void fromXml(XmlReader reader, TikXmlConfig config, LocationResult.body.items.item value) throws IOException {
        while(reader.hasAttribute()) {
          String attributeName = reader.nextAttributeName();
          if (config.exceptionOnUnreadXml() && !attributeName.startsWith("xmlns")) {
            throw new IOException("Unread attribute '"+ attributeName +"' at path "+ reader.getPath());
          }
          reader.skipAttributeValue();
        }
        value.endTime = reader.nextTextContentAsInt();
      }
    });
    childElementBinders.put("dutyEmcls", new ChildElementBinder<LocationResult.body.items.item>() {
      @Override
      public void fromXml(XmlReader reader, TikXmlConfig config, LocationResult.body.items.item value) throws IOException {
        while(reader.hasAttribute()) {
          String attributeName = reader.nextAttributeName();
          if (config.exceptionOnUnreadXml() && !attributeName.startsWith("xmlns")) {
            throw new IOException("Unread attribute '"+ attributeName +"' at path "+ reader.getPath());
          }
          reader.skipAttributeValue();
        }
        value.dutyEmcls = reader.nextTextContent();
      }
    });
    childElementBinders.put("dutyTel1", new ChildElementBinder<LocationResult.body.items.item>() {
      @Override
      public void fromXml(XmlReader reader, TikXmlConfig config, LocationResult.body.items.item value) throws IOException {
        while(reader.hasAttribute()) {
          String attributeName = reader.nextAttributeName();
          if (config.exceptionOnUnreadXml() && !attributeName.startsWith("xmlns")) {
            throw new IOException("Unread attribute '"+ attributeName +"' at path "+ reader.getPath());
          }
          reader.skipAttributeValue();
        }
        value.dutyTel1 = reader.nextTextContent();
      }
    });
    childElementBinders.put("longitude", new ChildElementBinder<LocationResult.body.items.item>() {
      @Override
      public void fromXml(XmlReader reader, TikXmlConfig config, LocationResult.body.items.item value) throws IOException {
        while(reader.hasAttribute()) {
          String attributeName = reader.nextAttributeName();
          if (config.exceptionOnUnreadXml() && !attributeName.startsWith("xmlns")) {
            throw new IOException("Unread attribute '"+ attributeName +"' at path "+ reader.getPath());
          }
          reader.skipAttributeValue();
        }
        value.longitude = reader.nextTextContentAsDouble();
      }
    });
  }

  @Override
  public LocationResult.body.items.item fromXml(XmlReader reader, TikXmlConfig config) throws IOException {
    LocationResult.body.items.item value = new LocationResult.body.items.item();
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
        ChildElementBinder<LocationResult.body.items.item> childElementBinder = childElementBinders.get(elementName);
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
  public void toXml(XmlWriter writer, TikXmlConfig config, LocationResult.body.items.item value, String overridingXmlElementTagName) throws IOException {
    if (value != null) {
      if (overridingXmlElementTagName == null) {
        writer.beginElement("item");
      } else {
        writer.beginElement(overridingXmlElementTagName);
      }
      writer.beginElement("rnum");
      writer.textContent(value.rnum);
      writer.endElement();
      writer.beginElement("distance");
      writer.textContent(value.distance);
      writer.endElement();
      writer.beginElement("latitude");
      writer.textContent(value.latitude);
      writer.endElement();
      writer.beginElement("cnt");
      writer.textContent(value.cnt);
      writer.endElement();
      if (value.dutyDivName != null) {
        writer.beginElement("dutyDivName");
        if (value.dutyDivName != null) {
          writer.textContent(value.dutyDivName);
        }
        writer.endElement();
      }
      if (value.dutyDiv != null) {
        writer.beginElement("dutyDiv");
        if (value.dutyDiv != null) {
          writer.textContent(value.dutyDiv);
        }
        writer.endElement();
      }
      if (value.dutyAddr != null) {
        writer.beginElement("dutyAddr");
        if (value.dutyAddr != null) {
          writer.textContent(value.dutyAddr);
        }
        writer.endElement();
      }
      writer.beginElement("dutyLvkl");
      writer.textContent(value.dutyLvkl);
      writer.endElement();
      if (value.dutyName != null) {
        writer.beginElement("dutyName");
        if (value.dutyName != null) {
          writer.textContent(value.dutyName);
        }
        writer.endElement();
      }
      if (value.hpid != null) {
        writer.beginElement("hpid");
        if (value.hpid != null) {
          writer.textContent(value.hpid);
        }
        writer.endElement();
      }
      if (value.dutyFax != null) {
        writer.beginElement("dutyFax");
        if (value.dutyFax != null) {
          writer.textContent(value.dutyFax);
        }
        writer.endElement();
      }
      writer.beginElement("startTime");
      writer.textContent(value.startTime);
      writer.endElement();
      writer.beginElement("endTime");
      writer.textContent(value.endTime);
      writer.endElement();
      if (value.dutyEmcls != null) {
        writer.beginElement("dutyEmcls");
        if (value.dutyEmcls != null) {
          writer.textContent(value.dutyEmcls);
        }
        writer.endElement();
      }
      if (value.dutyTel1 != null) {
        writer.beginElement("dutyTel1");
        if (value.dutyTel1 != null) {
          writer.textContent(value.dutyTel1);
        }
        writer.endElement();
      }
      writer.beginElement("longitude");
      writer.textContent(value.longitude);
      writer.endElement();
      writer.endElement();
    }
  }
}
