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
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

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
        String actualBranch = localRepo.getFullBranch();
        Git git = new Git(localRepo);//git para hacer comandos
        System.out.println(git.diff().call());
    }

    public static void push() throws Exception {
        Repository localRepo = new FileRepository("C:\\Users\\Yo\\Documents\\NetBeansProjects\\jgit\\.git");
        String actualBranch = localRepo.getFullBranch();
        System.out.println("Rama actual: " + actualBranch);
        Git git = new Git(localRepo);//git para hacer comandos
        List<Ref> branches = git.branchList().call();//lista de las ramas
        for (Ref b : branches) {
            System.out.println("Cambiando a rama: " + b.getName());
            git.checkout().setName(b.getName()).call();
            System.out.println("Pull para actualizar local");
            git.pull().call();
            System.out.println("Push para actualizar remote");
            git.push().setCredentialsProvider(
                    new UsernamePasswordCredentialsProvider(
                            "JesusHdezWaterloo",
                            "A123b456**"
                    )
            ).call();
        }
        git.checkout().setName(actualBranch).call();
    }
}
