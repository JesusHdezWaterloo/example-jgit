/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jgit;

import java.util.List;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.ListBranchCommand;
import org.eclipse.jgit.api.ListBranchCommand.ListMode;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;

/**
 *
 * @author Yo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Repository localRepo = new FileRepository("C:\\Users\\Yo\\Documents\\NetBeansProjects\\jgit\\.git");
        Git git = new Git(localRepo);
        List<Ref> branches = git.branchList().call();
        for (Ref b : branches) {
            System.out.println(b.getName());
        }
        
        git.checkout().setName("refs/heads/master").call();
    }

}
