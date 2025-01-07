import pandas as pd
import psycopg2
import os

# Connessione al database
conn = psycopg2.connect(
    dbname="pokedex",
    user="postgres",
    password="********",
    host="localhost",
    port="*****"
)
cur = conn.cursor()

# Leggi il file CSV
df = pd.read_csv('db/datiPokedex.csv', delimiter=';')

# Funzione per leggere l'immagine come byte array
def read_image(image_path):
    with open(image_path, 'rb') as file:
        return file.read()

# Inserisci i dati nel database
for index, row in df.iterrows():
    if (row['national_number'] < 10): 
        image_numeber = f"00{row['national_number']}"
    elif (row['national_number'] < 100):
        image_numeber = f"0{row['national_number']}"
    else:
        image_numeber = f"{row['national_number']}"
        
    image_path = f"db/images/{image_numeber}.png"  
    image_data = read_image(image_path) if os.path.exists(image_path) else None

    cur.execute("""
        INSERT INTO pokemon (
            national_number, gen, english_name, primary_type, secondary_type, classification,
            hp, attack, defense, sp_attack, sp_defense, speed, abilities_0, abilities_1, abilities_2,
            is_sublegendary, is_legendary, is_mythical, evochain_0, evochain_1, evochain_2, evochain_3,
            evochain_4, evochain_5, evochain_6, description, image
        ) VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)
    """, (
        int(row['national_number']),row['gen'], row['english_name'], row['primary_type'], row['secondary_type'],
        row['classification'], int(row['hp']), int(row['attack']), int(row['defense']), int(row['sp_attack']), int(row['sp_defense']),
        int(row['speed']), row['abilities_0'], row['abilities_1'], row['abilities_2'], bool(row['is_sublegendary']),
        bool(row['is_legendary']), bool(row['is_mythical']), row['evochain_0'], row['evochain_1'], row['evochain_2'],
        row['evochain_3'], row['evochain_4'], row['evochain_5'], row['evochain_6'], row['description'], psycopg2.Binary(image_data)
    ))

# Commit e chiudi la connessione
conn.commit()
cur.close()
conn.close()