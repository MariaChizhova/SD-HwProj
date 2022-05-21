export function formatDate(time) {
    if (typeof time !== "string") {
        return 'loading...';
    }
    const date = new Date(time);
    const hours = date.getHours();
    let minutes = date.getMinutes();
    minutes = minutes < 10 ? '0' + minutes : minutes;
    const strTime = hours + ':' + minutes;
    return date.getDate() + "." + (date.getMonth() + 1) + "." + date.getFullYear() + "  " + strTime;
}