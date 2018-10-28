@Library('my-shared') 
import static org.foo.Utilities.*  
import org.foo.Zot 
import org.foo.Parallel

//def utils = new Utilities(this); 
def z = new Zot() 
def p = new Parallel() 

def request = libraryResource 'org/m2m/request.json'

node{
    mvn this, 'clean package'
    z.checkOutFrom 'copiloto-repo'
    log.info 'Starting'
    log.warning 'Nothing to do!'
    sayHello 'Joe'
    windows{
        echo 'executando no windows'
    }
    p.parallelize(17)
    echo "${request}"
}