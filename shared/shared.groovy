@Library('my-shared')
import org.foo.Utilities.*  
import org.foo.Zot 

//def utils = new Utilities(this); 
def z = new Zot() 

node{
    mvn this, 'clean package'
    z.checkOutFrom 'copiloto-repo'
}