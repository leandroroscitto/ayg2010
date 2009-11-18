package formateadores;

import java.text.ParseException;

import javax.swing.JFormattedTextField;

public class FormateadorTel extends JFormattedTextField.AbstractFormatter
{
	private static final long serialVersionUID = 1L;

	/** Se le pasa el texto del editor y debe devolver una clase TTelefono */
    public Object stringToValue(String text) throws ParseException
    {
        return new TTelefono(text,this.getFormattedTextField().getValue().toString());
    }

    /** Se le pasa una clase Mayuscula o null y devuelve la cadena para poner en
           el editor */
    public String valueToString(Object value) throws ParseException
    {
        if (value==null)
            return ("");
        return value.toString();
    }
}