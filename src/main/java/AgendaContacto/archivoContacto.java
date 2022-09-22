package AgendaContacto;

import java.io.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Nathalie
 */
public class archivoContacto {

    /* Creación archivo */
    File archivo;

    public void crearArchivo() {
        try {
            archivo = new File("AgendaContactos.txt");
            if (archivo.createNewFile()) {
                JOptionPane.showMessageDialog(null, "Archivo Creado ");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void DiligenciarArchivo(UsuarioContacto UsuarioContacto) {
        try {
            FileWriter diligenciar = new FileWriter(archivo, true);
            diligenciar.write(UsuarioContacto.getNombre() + "%" + UsuarioContacto.getApellido() + "%" + UsuarioContacto.getTelefono() + "\r\n");
            diligenciar.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static boolean ValidarTelefono(String FilePath, String telefono) {
        try {
            BufferedReader buff = new BufferedReader((new FileReader(FilePath)));
            String s; 
            while ((s=buff.readLine())!=null){
                if (s.trim().contains(telefono)){
                    return true;
                }
            }
            buff.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return false;
    }

}
