import './Counter.css'
import { PropTypes } from 'prop-types'

export default function CounterButton({ by = 1, incrementMethod, decrementMethod }) {
    return (
        <div className="Counter">
            <div>
                <div>
                </div>
                <button className="counterButton"
                    onClick={() => incrementMethod(by)}
                >
                    +{by}
                </button>
                <button className="counterButton"
                    onClick={() => decrementMethod(by)}
                >
                    -{by}
                </button>
            </div>
        </div>
    )
}

CounterButton.propTypes = {
    by: PropTypes.number,
    incrementMethod: PropTypes.func.isRequired,
    decrementMethod: PropTypes.func.isRequired
};