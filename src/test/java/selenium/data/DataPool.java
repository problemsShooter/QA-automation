package selenium.data;

import models.FromJson;
import processing.data.JSONArray;
import processing.data.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import static processing.core.PApplet.loadJSONObject;

public class DataPool<T extends FromJson<T> > {
    Collection<T> collection;
    final Class<T> typeParameterClass;

    public DataPool(Class<T> typeParameterClass) {
        this.typeParameterClass = typeParameterClass;
    }

    public void processDataFile( T typeGeneric,String filePath, String key) {
        JSONObject jsonObject;
        File file = new File(filePath);
        jsonObject = loadJSONObject(file);

        JSONArray jsonArray;
        jsonArray = jsonObject.getJSONArray(key);

        collection = new ArrayList<T>(jsonArray.size());
        for(int i = 0; i<jsonArray.size(); i++){
            try{
                jsonObject = jsonArray.getJSONObject(i);
            }
            catch (Exception e){
                e.printStackTrace();
                continue;
            }
            T type = typeGeneric.fromJson(jsonObject);//it would better to do this without typeGeneric

            if(type!=null){
                collection.add(type);
            }
        }
    }

    public Object[] getData() {
        Object[] data = new Object[collection.size()];
        Iterator<T> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            data[i] = it.next();
            i++;
        }
        return data;
    }

    public Collection<T> getCollection() {
        return collection;
    }
}
