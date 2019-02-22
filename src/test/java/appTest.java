import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import dev.utils.StringUtils;

@RunWith(Parameterized.class)
public class appTest {

	@Parameters
	public static Collection<Object[]> datas() {
		List<Object[]> datas = new ArrayList<Object[]>();
		datas.add(new Object[] { "chat", "chats", 1 });
		datas.add(new Object[] { "machins", "machine", 1 });
		datas.add(new Object[] { "aviron", "avion", 1 });
		datas.add(new Object[] { "distance", "instance", 2 });
		datas.add(new Object[] { "Chien", "Chine", 2 });
		datas.add(new Object[] { "Chien", null, 2 });
		return datas;

	}

	@Parameter
	public String mot1;
	@Parameter(value = 1)
	public String mot2;
	@Parameter(value = 2)
	public int expected;

	@Test(expected = NullPointerException.class)
	public void testString(){

		assertEquals("Compare", expected, StringUtils.levenshteinDistance(mot1, mot2));
	}


}
