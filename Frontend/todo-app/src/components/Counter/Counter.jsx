import { useState } from 'react'
import './Counter.css'
import CounterButton from './CounterButton'

export default function Counter() {
    //[0, ƒ]
    const [count, setCount] = useState(0);

    function incrementCounterParentFunction(by) {
        //calling the function and updating the current state value
        setCount(count + by)
    }

    function decrementCounterParentFunction(by) {
        setCount(count - by)
    }

    function resetCounter() {
        setCount(0)
    }

    return (
        <div>
            <div>
                <span className="totalCount">
                    {count}
                </span>
            </div>
            <CounterButton by={1}
                incrementMethod={incrementCounterParentFunction}
                decrementMethod={decrementCounterParentFunction} />
            <CounterButton by={2}
                incrementMethod={incrementCounterParentFunction}
                decrementMethod={decrementCounterParentFunction} />
            <CounterButton by={5}
                incrementMethod={incrementCounterParentFunction}
                decrementMethod={decrementCounterParentFunction} />
            <button className="resetButton"
                onClick={resetCounter}
            //style={customStyle}
            >
                Reset
            </button>
        </div>
    )
}