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

public class items$$TypeAdapter implements TypeAdapter<LocationResult.body.items> {
  private Map<String, ChildElementBinder<LocationResult.body.items>> childElementBinders = new  HashMap<String, ChildElementBinder<LocationResult.body.items>>();

  public items$$TypeAdapter() {
    childElementBinders.put("item", new ChildElementBinder<LocationResult.body.items>() {
      @Override
      public void fromXml(XmlReader reader, TikXmlConfig config, LocationResult.body.items value) throws IOException {
        if (value.item == null) {
          value.item = new ArrayList<LocationResult.body.items.item>();
        }
        value.item.add((LocationResult.body.items.item) config.getTypeAdapter(LocationResult.body.items.item.class).fromXml(reader, config) );
      }
    });
  }

  @Override
  public LocationResult.body.items fromXml(XmlReader reader, TikXmlConfig config) throws IOException {
    LocationResult.body.items value = new LocationResult.body.items();
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
        ChildElementBinder<LocationResult.body.items> childElementBinder = childElementBinders.get(elementName);
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
  public void toXml(XmlWriter writer, TikXmlConfig config, LocationResult.body.items value, String overridingXmlElementTagName) throws IOException {
    if (value != null) {
      if (overridingXmlElementTagName == null) {
        writer.beginElement("items");
      } else {
        writer.beginElement(overridingXmlElementTagName);
      }
      if (value.item != null) {
        List<LocationResult.body.items.item> list = value.item;
        int listSize = list.size();
        for (int i =0; i<listSize; i++) {
          LocationResult.body.items.item item = list.get(i);
          config.getTypeAdapter(LocationResult.body.items.item.class).toXml(writer, config, item, "item");
        }
      }
      writer.endElement();
    }
  }
}
