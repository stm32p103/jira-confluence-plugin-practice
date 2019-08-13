package com.stm32p103.plugin.macro;

import com.atlassian.confluence.content.render.xhtml.ConversionContext;
import com.atlassian.confluence.macro.Macro;
import com.atlassian.confluence.macro.MacroExecutionException;
import com.atlassian.confluence.xhtml.api.MacroDefinition;

import java.util.Map;

public class idcontainer implements Macro {
	public String execute(Map<String, String> map, String s, ConversionContext conversionContext) throws MacroExecutionException {
		MacroDefinition macroDefinition = (MacroDefinition) conversionContext.getProperty("macroDefinition");
		String macroId = macroDefinition.getMacroId().toString();
		int startIndex = macroId.indexOf( "@" );
		int endIndex = macroId.indexOf( ")" );
		String id = macroId.substring( startIndex + 1, endIndex - 1 );
		return "<id-container id=" + id + ">" + macroDefinition.getBodyText() + "</id-container>";
	}
	public BodyType getBodyType() { return BodyType.RICH_TEXT; }
	public OutputType getOutputType() { return OutputType.INLINE; }
}
