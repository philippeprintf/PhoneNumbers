import { PhoneNumber } from "./phoneNumber";

export class Customer {
    constructor(
        public id: number,
        public name: string,
        public phoneNumber: PhoneNumber
    ) { }
}