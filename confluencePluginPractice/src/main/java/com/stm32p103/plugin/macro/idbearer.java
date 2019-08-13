package com.stm32p103.plugin.macro;

import com.atlassian.confluence.content.render.xhtml.ConversionContext;
import com.atlassian.confluence.macro.Macro;
import com.atlassian.confluence.macro.MacroExecutionException;
import com.atlassian.confluence.xhtml.api.MacroDefinition;

import java.util.Map;

public class idbearer implements Macro {
	public String execute(Map<String, String> map, String s, ConversionContext conversionContext) throws MacroExecutionException {
		MacroDefinition macroDefinition = (MacroDefinition) conversionContext.getProperty("macroDefinition");
		String macroId = macroDefinition.getMacroId().toString();
		int startIndex = macroId.indexOf( "@" );
		int endIndex = macroId.indexOf( ")" );
		String id = macroId.substring( startIndex + 1, endIndex - 1 );

		// マクロIDから、ハッシュのみ抜粋して、idに設定
		return "<id-bearer id=\"" + id + "\"></id-bearer>";
	}
	public BodyType getBodyType() {
		// NONE: マクロの内側がない
		// PLAIN_TEXT: マクロの内側にテキストが入れられる
		// RICH_TEXT: マクロ内側にリッチテキスト(リストや見出しなど)が入れられる
		return BodyType.NONE;
	}

	public OutputType getOutputType() {
		return OutputType.BLOCK;
	}
}
