package com.stm32p103.plugin.macro;

import com.atlassian.confluence.content.render.xhtml.ConversionContext;
import com.atlassian.confluence.macro.Macro;
import com.atlassian.confluence.macro.MacroExecutionException;
import com.atlassian.confluence.xhtml.api.MacroDefinition;

import java.util.Map;

public class IdContainer implements Macro {
  public String execute( Map<String, String> map, String body, ConversionContext conversionContext) throws MacroExecutionException {
    // ConversionContext: https://docs.atlassian.com/atlassian-confluence/5.9.9/com/atlassian/confluence/content/render/xhtml/ConversionContext.html
    // getProperty: https://docs.atlassian.com/atlassian-confluence/5.9.9/com/atlassian/confluence/content/render/xhtml/ConversionContextPropertyName.html
    MacroDefinition macroDefinition = (MacroDefinition) conversionContext.getProperty("macroDefinition");

    // id取得: https://community.atlassian.com/t5/Answers-Developer-Questions/How-to-get-Confluence-macro-id-on-execute/qaq-p/474165
    String macroId = macroDefinition.getMacroId().get().getId();
    String tag = map.get( "tag" );
    String key = map.get( "key" );
    
    // idを設定しt<id-container>タグで本文(body)を囲む。
    return "<" + tag + " id=\"" + macroId + "\" key=\"" + map.get( "key" ) + "\" >" + body + "</" + tag + ">";
  }
  public BodyType getBodyType() {
    // NONE: マクロの内側がない
    // PLAIN_TEXT: マクロの内側にテキストが入れられる
    // RICH_TEXT: マクロ内側にリッチテキスト(リストや見出しなど)が入れられる
    return BodyType.RICH_TEXT;
  }

  public OutputType getOutputType() {
    return OutputType.BLOCK;
  }
}
