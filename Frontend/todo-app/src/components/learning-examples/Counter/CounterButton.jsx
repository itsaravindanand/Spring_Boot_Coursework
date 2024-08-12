import { useState } from 'react'
import './Counter.css'
import { PropTypes } from 'prop-types'

export default function CounterButton({ by, incrementMethod, decrementMethod }) {
    // const customStyle = {
    //     backgroundColor: "green",
    //     fontSize: "16px",
    //     padding: "15px 30px",
    //     color: "white",
    //     width: "100px",
    //     border: "1px solid #666666",
    //     borderRadius: "30px",
    // };
    //[0, ƒ]
    const [count, setCount] = useState(0);

    function incrementCounterFunction() {
        //calling the function and updating the current state value
        setCount(count + by)
        //console.log(count)
        incrementMethod(by)
    }

    function decrementCounterFunction() {
        //calling the function and updating the current state value
        setCount(count - by)
        //console.log(count)
        decrementMethod(by)
    }

    return (
        <div className="Counter">
            <div>
                <div>
                    {/* <span className="count">
                        {count}
                    </span> */}
                </div>
                <button className="counterButton"
                    onClick={incrementCounterFunction}
                //style={customStyle}
                >
                    +{by}
                </button>
                <button className="counterButton"
                    onClick={decrementCounterFunction}
                //style={customStyle}
                >
                    -{by}
                </button>
            </div>
        </div>
    )
}

CounterButton.propTypes = {
    by: PropTypes.number
}

CounterButton.defaultProps = {
    by: 1
}