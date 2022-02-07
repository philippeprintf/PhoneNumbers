import { Country } from "./country";

export class PhoneNumber {
    constructor(
        public number: string,
        public country: Country,
        public numberValid: boolean
    ) { }
}