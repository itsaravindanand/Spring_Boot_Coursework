import "./App.css";
import TodoApp from "./components/todo/TodoApp";

function App() {
  return (
    <div className="App"> 
    <TodoApp></TodoApp>
        
     {/* <div className="counterText">
     Counter Application
     </div> */}
     {/* <PlayingWithProps property1="value1" property2="value2"/> */}
     {/* <Counter/> */}
    </div>
  )
}
// //{property1:'value1', property2:'value2'}
// function PlayingWithProps(properties){
//   console.log(properties)
//   console.log(properties.property1)
//   console.log(properties.property2)
//   return (
//     <div>
//       Props
//     </div>
//   )
// }

// //{property1:'value1', property2:'value2'}
// function PlayingWithProps({property1,property2}){
//   console.log(property1)
//   console.log(property2)
//   return (
//     <div>
//       Props
//     </div>
//   )
// }
export default App;