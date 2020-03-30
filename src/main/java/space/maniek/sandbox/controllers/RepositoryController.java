package space.maniek.sandbox.controllers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/repository")
public class RepositoryController{

    @GetMapping("/history")
    public List<String> getHistory(){
        ArrayList<String> tasks = new ArrayList<String>();
        
        Git git = null;
        try{
            Repository existingRepo = new FileRepositoryBuilder()
            .setGitDir(new File(".git"))
            .build();
            git = new Git(existingRepo);
            
        String treeName = "refs/heads/master"; // tag or branch
        for (RevCommit commit : git.log().add(existingRepo.resolve(treeName)).call()) {
            tasks.add(commit.getFullMessage());
        }
        }catch(Exception e){

        }finally{
            if(git!=null){
               git.close();
            }
        }

        return tasks;
    }
}