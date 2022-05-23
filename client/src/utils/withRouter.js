import {useNavigate, useSearchParams} from "react-router-dom";

/**
 * Wrapper for the components class that provides the ability to use the navigation functions
 * @param Child
 * @returns {function(*): *}
 */
export function withRouter( Child ) {
    return ( props ) => {
        const [searchParams] = useSearchParams();
        const navigate = useNavigate();
        return <Child { ...props } params={searchParams} navigate={navigate} />;
    }
}