package ut.com.stm32p103.plugin;

import org.junit.Test;
import com.stm32p103.plugin.api.MyPluginComponent;
import com.stm32p103.plugin.impl.MyPluginComponentImpl;

import static org.junit.Assert.assertEquals;

public class MyComponentUnitTest
{
    @Test
    public void testMyName()
    {
        MyPluginComponent component = new MyPluginComponentImpl(null);
        assertEquals("names do not match!", "myComponent",component.getName());
    }
}