package services;
import models.Enseignant;
import models.Filliere;
import models.Module;
import java.util.ArrayList;

public class ModuleService {
    public static Module addModule(String intitule, Enseignant professeur,  Filliere filliere) {
        Module module= new Module();
        module.setIntitule(intitule);
        module.setProfesseur(professeur);
        module.setId(DB.getFilId());
        module.setFilliere(filliere);
        DB.modules.add(module);

        return module;
    }

    public static Module updateModule(int id , String intitule, Enseignant professeur, Filliere filliere){
        for (Module module : DB.modules) {
            if (module.getId() == id) {
                module.setIntitule(intitule);
                module.setProfesseur(professeur);
                module.setId(DB.getModId());
                module.setFilliere(filliere);
            }
            return module;
        }
        return  new Module();
    }
    public static Module getModuleById(int id){
        for(Module module:DB.modules) {
            if(module.getId()==id)
                return module;
        }
        return  new Module();
    }

    public static ArrayList<Module> deleteModuleById(int id){
        DB.modules.remove(getModuleById(id));
        return DB.modules;
    }



    public static ArrayList<Module> getAllModule(){
        return  DB.modules;
    }
}