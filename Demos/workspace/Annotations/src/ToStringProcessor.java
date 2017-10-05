// ToStringProcessor.java

import static javax.lang.model.SourceVersion.RELEASE_7;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;

import javax.tools.Diagnostic;

@SupportedAnnotationTypes("ToString")
@SupportedSourceVersion(RELEASE_7)
public class ToStringProcessor extends AbstractProcessor
{
   public boolean process(Set<? extends TypeElement> annotations,
                          RoundEnvironment roundEnv)
   {
      if (!roundEnv.processingOver())
      {
         Set<? extends Element> elements;
         elements = roundEnv.getElementsAnnotatedWith(ToString.class);

         Iterator<? extends Element> iter = elements.iterator();
         while (iter.hasNext())
         {
            Element element = iter.next();

            if (element.getKind() != ElementKind.CLASS)
            {
               error("@ToString must prefix a class -- "+element+
                     " is not a class");
               continue;
            }

            List<? extends Element> subElements;
            subElements = element.getEnclosedElements();
            Iterator<? extends Element> iterChild = subElements.iterator();

            boolean found = false;
            while (iterChild.hasNext())
            {
               Element subElement = iterChild.next();

               if (subElement.toString().equals("toString()"))
               {
                  found = true;
                  break;
               }
            }

            if (!found)
               error("toString() not overridden in class "+element);                 
         }
      }

      return true;
   }

   void error(String msg)
   {
      processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, msg);
   }
}
