@Library('my-shared')
import org.foo.Utilities 
@Library('my-shared')
import org.foo.Zot 

def utils = new Utilities(this); 
def z = new Zot() 

node{
    utils.mvn 'clean package'
    z.checkOutFrom 'copiloto-repo'
}