package tech.jhipster.forge.common.secondary;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import java.io.IOException;
import java.io.StringWriter;

public class MustacheUtils {

  private MustacheUtils() {}

  public static String template(String file, Object object) throws IOException {
    MustacheFactory mf = new DefaultMustacheFactory();
    Mustache m = mf.compile(file);

    StringWriter writer = new StringWriter();
    m.execute(writer, object).flush();

    return writer.toString();
  }
}
