import {useNavigate, useSearchParams} from "react-router-dom";

export function withRouter( Child ) {
    return ( props ) => {
        const [searchParams] = useSearchParams();
        const navigate = useNavigate();
        return <Child { ...props } params={searchParams} navigate={navigate} />;
    }
}