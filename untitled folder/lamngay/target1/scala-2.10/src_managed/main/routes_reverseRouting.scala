// @SOURCE:/Users/tuanna/Desktop/luu2705/project/lamngay/conf/routes
// @HASH:785b9b610a109e22bba0d48fc2502c8f21ecb87d
// @DATE:Thu May 29 11:49:58 ICT 2014

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString


// @LINE:11
// @LINE:10
// @LINE:8
// @LINE:7
// @LINE:6
package controllers {

// @LINE:8
// @LINE:7
class ReverseFindJobs {
    

// @LINE:7
def details(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "details")
}
                                                

// @LINE:8
def search(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "search")
}
                                                
    
}
                          

// @LINE:10
class ReverseAssets {
    

// @LINE:10
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:11
// @LINE:6
class ReverseApplication {
    

// @LINE:11
def join(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "join")
}
                                                

// @LINE:6
def index(): Call = {
   Call("GET", _prefix)
}
                                                
    
}
                          
}
                  


// @LINE:11
// @LINE:10
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.javascript {

// @LINE:8
// @LINE:7
class ReverseFindJobs {
    

// @LINE:7
def details : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.FindJobs.details",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "details"})
      }
   """
)
                        

// @LINE:8
def search : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.FindJobs.search",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "search"})
      }
   """
)
                        
    
}
              

// @LINE:10
class ReverseAssets {
    

// @LINE:10
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:11
// @LINE:6
class ReverseApplication {
    

// @LINE:11
def join : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.join",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "join"})
      }
   """
)
                        

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        
    
}
              
}
        


// @LINE:11
// @LINE:10
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.ref {


// @LINE:8
// @LINE:7
class ReverseFindJobs {
    

// @LINE:7
def details(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.FindJobs.details(), HandlerDef(this, "controllers.FindJobs", "details", Seq(), "GET", """""", _prefix + """details""")
)
                      

// @LINE:8
def search(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.FindJobs.search(), HandlerDef(this, "controllers.FindJobs", "search", Seq(), "GET", """""", _prefix + """search""")
)
                      
    
}
                          

// @LINE:10
class ReverseAssets {
    

// @LINE:10
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:11
// @LINE:6
class ReverseApplication {
    

// @LINE:11
def join(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.join(), HandlerDef(this, "controllers.Application", "join", Seq(), "GET", """""", _prefix + """join""")
)
                      

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      
    
}
                          
}
        
    