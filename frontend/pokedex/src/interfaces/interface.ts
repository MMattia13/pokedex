export default interface IUser {
    id: number;
    name: string;
    email: string;
    password: string;
}

export default interface IPokemon {
    nationalNumber: number;
    gen: string;
    englishName: string;
    primaryType: string;
    secondaryType?: string;
    classification: string;
    hp: number;
    attack: number;
    defense: number;
    spAttack: number;
    spDefense: number;
    speed: number;
    abilities: string[];
    isSublegendary: boolean;
    isLegendary: boolean;
    isMythical: boolean;
    evoChain: string[];
    description: string;
    image?: string;
}