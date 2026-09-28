package com.example.StorageApp;

import com.example.StorageApp.exception.FileNotFoundException;
import com.example.StorageApp.exception.NotDirectoryException;
import org.springframework.stereotype.Component;
import java.util.*;
@Component
public class FileNode {
    private File file;
    private String uuid=null;
    private static Map<String,FileNode> uuidMap=new HashMap<>();

    public void setFiles() {
        if (!file.isDirectory()){
            files=null;
        }
        else files=new ArrayList<>();
    }

    private List<FileNode> files;
    private FileNode parent=null;

    public void setUuid() {
        this.uuid = uuid;
        while (uuidMap.containsKey(this.file.getUuid())){
            this.file.changeUuid();
            this.uuid=this.file.getUuid();
        }
    }
    public FileNode(File file) {
        this.file = file;
        setUuid();
        setFiles();

    }
    public FileNode(String filename){
        this.file=new File(filename,false);
        setUuid();
        setFiles();
    }

    public FileNode addFileNode(FileNode fileNode) throws NotDirectoryException {
        File currentFile=fileNode.file;
        if (currentFile.isDirectory()){
            while(uuidMap.containsKey(currentFile.getUuid())){
                currentFile.changeUuid();
            }
            uuidMap.put(currentFile.getUuid(),fileNode);
            fileNode.parent=this;
            files.add(fileNode);
            return fileNode;
        }
        else {
            throw new NotDirectoryException("File is not a directory. Can not add file");
        }
    }

    public List<FileNode> listFiles(){
        return files;
    }

    public FileNode searchFile(String uuid) throws FileNotFoundException {
      if (uuidMap.containsKey(uuid))
      {
          return uuidMap.get(uuid);
      }
      else throw new FileNotFoundException("No file with the uuid found");
    }

    public List<FileNode> searchFiles(String filename) throws FileNotFoundException {
        List<FileNode> results = new ArrayList<>(List.of(new FileNode[0]));
        for(FileNode node:uuidMap.values())
        {
            File currenFile=node.file;
            if(currenFile.getFilename().equals(filename))
            {
                results.add(node);
            }
        }
        if (!results.isEmpty())
        {
            return results;
        }
            else throw new FileNotFoundException("No file with the given filename found");
    }


    public static void main(String[] args) {
        File file=new File("chinmay",true);
        FileNode node=new FileNode(file);
//        try{
////            node.addFileNode(new FileNode(new File("chinmaycbhat's files",true))).addFileNode(new FileNode(new File()));
//
//        }
//        catch (NotDirectoryException ignored){}
//

    }
}
