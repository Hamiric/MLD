package com.example.mylittledoctor;

import com.tickaroo.tikxml.TikXmlConfig;
import com.tickaroo.tikxml.XmlReader;
import com.tickaroo.tikxml.XmlWriter;
import com.tickaroo.tikxml.typeadapter.ChildElementBinder;
import com.tickaroo.tikxml.typeadapter.TypeAdapter;
import java.io.IOException;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class items$$TypeAdapter implements TypeAdapter<items> {
  private Map<String, ChildElementBinder<items>> childElementBinders = new  HashMap<String, ChildElementBinder<items>>();

  public items$$TypeAdapter() {
    childElementBinders.put("item", new ChildElementBinder<items>() {
      @Override
      public void fromXml(XmlReader reader, TikXmlConfig config, items value) throws IOException {
        if (value.item == null) {
          value.item = new ArrayList<item>();
        }
        value.item.add((item) config.getTypeAdapter(item.class).fromXml(reader, config) );
      }
    });
  }

  @Override
  public items fromXml(XmlReader reader, TikXmlConfig config) throws IOException {
    items value = new items();
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
        ChildElementBinder<items> childElementBinder = childElementBinders.get(elementName);
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
  public void toXml(XmlWriter writer, TikXmlConfig config, items value, String overridingXmlElementTagName) throws IOException {
    if (value != null) {
      if (overridingXmlElementTagName == null) {
        writer.beginElement("items");
      } else {
        writer.beginElement(overridingXmlElementTagName);
      }
      if (value.item != null) {
        List<item> list = value.item;
        int listSize = list.size();
        for (int i =0; i<listSize; i++) {
          item item = list.get(i);
          config.getTypeAdapter(item.class).toXml(writer, config, item, "item");
        }
      }
      writer.endElement();
    }
  }
}
